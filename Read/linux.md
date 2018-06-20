## 在linux云服务器环境下搭建javaweb开发环境

------
## CSDN上有详细教程：
	https://blog.csdn.net/wsh596823919/article/details/79717993
---
## 第一步：centos安装jdk
1、下载jdk  我这里下载的是 jdk1.8.0_161.tar.gz

2、在linux服务器上新建jdk的文件夹

    进入/usr/local文件夹下，新建一个jdk的目录、

	cd /usr/local/
	mkdir jdk
3、如果jdk是下载到自己的电脑上，那么通过可以通过WinSCP这个软件将文件上传到云端的文件中

4、进入到jdk的文件所在的目录，linux下解压.tar.gz文件

	tar -zxvf jdk1.8.0_161
5、配置java的运行环境变量

    通过vim打开  (如果没安装vim编辑器可以使用vi命令打开默认的vi编辑器)  

    输入：Vim /etc/profile     然后按下  i  键，表示insert插入操作，然后移动到末尾，在末尾加入以下 

	JAVA_HOME=/usr/local/jdk/jdk1.8.0_161      //jdk安装目录 

	PATH=$JAVA_HOME/bin:$PATH 
	
	CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 

	export JAVA_HOME 

	export PATH 
    输入完成后 输入":wq" 表示保存并退出vim编辑

6、OK，环境配置完成，检验是否配置成功 输入 java -version 若显示java版本，则成功

    若未成功，那么再打开vim检查是否有错误



## 第二步：centos安装tomcat
1、下载tomcat安装包  tomcat  

    最好下载.tar.gz文件，版本tomcat7,8,9都可以

2、建立tomcat的存储文件夹 ，和之前jdk的类似，也是在/usr/local/下

	cd /usr/local 
	mkdir tomcat
3、可以先下载到本机上，然后通过WinSCP将压缩包上传

4、进入tomcat压缩包的目录，解压缩

     tar -zxvf  文件名   

（这里tomcat压缩包的名字很长，所以可以打出开头的几个字母，然后按Tab键自动补全！）

5、进入到tomcat/bin文件

 启动tomcat服务：运行./startup.sh启动tomcat

 关闭tomcat服务：运行./shutdown.sh关闭tomcat



若报错：可能是某个环节的配置出现问题，可以google一下或者先放在一边，看到第四步防火墙

注意：若要进行操作，最好先关闭服务，包括后面要上传项目，也要先关闭服务



## 第三步：安装mariadb（mysql）
mariadb其实就是mysql，只是mariadb他是开源的，他的命令也是mysql，都一样

一、安装MariaDB   这里可以从官网下载 或者直接从仓库通过yum指令下载

	yum update   #更新一下仓库 
	yum install mariadb mariadb-server     # CentOS下的yum
2、一但MariaDB软件包完成了安装，需要确保数据库服务启动运行，并且能开机自动启动 

	systemctl start mariadb 
	systemctl enable mariadb
	
3、MariaDB的安全加固 完成以上操作后，是时候对MariaDB的安全进行加固了。需要运行mysql_secure_installation脚本。

输入此脚本：

	mysql_secure_installation
按照步骤开始进行配置，具体含义如下列表：默认的话一直按y或者回车就行了

注意：第一次运行的时候，它会询问密码是什么，但我们还没设置，这时候一直按回车就行了，一般三次后就会让你设置密码

为数据库root用户设置或重置密码
禁止匿名用户登录
禁止root用户的远程访问，只允许本地localhost访问
删除test数据库（任何人都可以访问的数据库）
激活以上1～4选项
4、在CentOS系统中，还需要告诉SELinux允许MariaDB的监听端口穿透防火墙，然后重启服务。

 	yum install policycoreutils-python
	
 	semanage port -a -t mysqld_port_t -p tcp 20500



### PS：配置远程访问mariadb
如果你希望在本机上访问远程服务器，那么就要对服务器的mariadb进行远程配置

1、允许远程访问mariadb数据库 首先配置允许访问的用户，采用授权的方式给用户权限 

GRANT ALL PRIVILEGES ON . TO 'root'@'%'IDENTIFIED BY '123456' WITH GRANT OPTION;  
说明：root是登陆数据库的用户，123456是登陆数据库的密码，*就是意味着任何来源任何主机反正就是权限很大的样子。 

2、最后配置好权限之后不应该忘记刷新使之生效 

flush privileges;  
再次访问就可以了。



## 第四步：配置防火墙iptable
centos默认的防火墙是Firewalls，我们把它卸载，然后配置我们的防火墙

1.关闭默认的firewall防火墙 

	systemctl stop firewalld.service #停止firewall

	systemctl disable firewalld.service #禁止firewall开机启动
	firewall-cmd --state #查看默认防火墙状态（关闭后显示notrunning，开启后显示running）
2.开启iptables防火墙服务

	iptables yum install iptables （根据centOS7的版本和内核，有些版本已经装过，可以跳过此命令）

	yum install iptables-services
	service iptables restart
	chkconfig iptables on或者systemctl enable iptables.service开机自启
3.编辑防火墙文件（开启了21,22,80,3306端口） 

3306端口一般用于数据库访问，如jdbc连接mysql

22用于文件传输

添加你需要添加的端口...

    vim /etc/sysconfig/iptables   加入以下加粗的命令

	sampleconfiguration for iptables service   you can edit thismanually or use system-config-firewall
	please do not askus to add additional ports/services to this default configuration
	*filter
	:INPUT ACCEPT [0:0]
	:FORWARD ACCEPT [0:0]
	:OUTPUT ACCEPT [0:0]   -A INPUT -m state --state RELATED,ESTABLISHED -j ACCEPT  
	-A INPUT -p icmp -j ACCEPT
	-A INPUT -i lo -j ACCEPT
	-A INPUT -p tcp -m state --state NEW -m tcp --dport 21 -j ACCEPT
	-A INPUT -p tcp -m state --state NEW -m tcp --dport 22 -j ACCEPT
	-A INPUT -p tcp -m state --state NEW -m tcp --dport 80 -j ACCEPT
	-A INPUT -p tcp -m state --state NEW -m tcp --dport 3306 -j ACCEPT
	-A INPUT -j REJECT --reject-with icmp-host-prohibited
	-A FORWARD -j REJECT --reject-with icmp-host-prohibited
	COMMIT

4.查看本机关于IPTABLES的设置情况 

    iptables -L -n


## 第五步：建立mysql数据库
以上配置若都完成了，那么就可以建立我们的数据库了

1、登录mariadb 

	mysql -uroot -p
    然后输入密码

sql常用命令如下：(大小写无所谓，但要统一)

    展示数据库 SHOW DATABASES;

    使用数据库 USE USERS;

    展示表 SHOW TABLES;

    表信息 DESCRIBE <表名>;

    创建表user CREATE TABLE user( Id int, Name varchar(20), Password varchar(20), Level varchar(20), PRIMARY KEY(id) );

    获取表信息 Select * from user;


## 第六步：打包war
可以打开我当时自己写的一个网站，下载下来打开就可以直接部署了 https://github.com/kevinten10/java-web-servlet-mysql ，当然，里面的配置或者用户名之类的都是我的，你改成自己的就可以了

如果你有javaweb的项目，那么需要把项目生成特殊的压缩形式.war，然后上传，tomcat会解压war然后将它作为项目运行

1、将程序打包成war文件

    右键点击项目，选择导出-->war文件，他就会帮你把项目打包成war然后放到你指定的目录下

2、关闭tomcat服务./shutdown.sh

3、war上传到/tomcat/webapps/

4、启动tomcat服务./startup.sh

5、登录ip.ip.ip.ip:8080/<war的名字>

    就能打开你上传的项目了


### PS：如何删除上一个tomcat部署项目
1、删除/webapps/下的XXXX.war和xxxx项目文件

2、删除/work/catalina/localhost/XXXX项目文件

3、重新部署.war即可

1.stop tomcat服务器 

2.删除webapp下的该项目 

3.将work/Catalina/localhost目录下的该项目删除


### PS：安装jdbc驱动模块
解决办法是要引入JDBC的driver。下载了"connector/j"的jar文件，然后在项目里新建文件夹lib，把MySQL的JDBC driver拖拽进来。  



  随后又在整个项目的Java Build Path里面把driver作为作为internal jar导入。



  另外一种方法，新建lib文件夹，直接在"Java Build Path"里面添加一个External Jar也可以达到同样的效果。
  
  # LifeCat 智能成长相册管理网站
![image](https://img-blog.csdn.net/20180421144930399?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

### 功能简介：
	登录、注册、设置用户个人信息、修改密码、上传日记、上传图片、展示图片、使用python机器学习算法进行相册智能操作......
![image](https://img-blog.csdn.net/20180510163251506?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

### 网站预览:
	--->http://47.106.11.84--->点击“进入相册”即可进入相册首页  

### 网站展示：首页为wordpress搭建  

![image](https://img-blog.csdn.net/20180421144930399?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) 

![image](https://img-blog.csdn.net/20180510162236159?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  

![image](https://img-blog.csdn.net/20180510162329894?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  

![image](https://img-blog.csdn.net/20180510162344150?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70    )  

![image](https://img-blog.csdn.net/20180510162356345?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  

![image](https://img-blog.csdn.net/20180510162415759?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)  
