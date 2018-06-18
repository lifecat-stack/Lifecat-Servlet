## 数据库SQL

---
### 数据库分析

---
#### 数据库范式
    1NF - First Normal Form 符合1NF的关系中的每个属性都是原子的不可再分。
    2NF - Second Normal Form 满足1NF，数据库表中的每列都完全依赖于主键。
    3NF - Third Normal Form 满足2NF，要求一个数据库表中不包含已在其它表中已包含的非主关键字信息。
    BCNF - Boyce–Codd Normal Form 满足3NF，主属性内部不能部分或传递依赖
#### 建表规约
    * √ 1 :字段若非负，必须是unsigned
    * √ 1 :表达是否概念，必须使用is_xxx方式，数据类型为unsigned tinyint(1是，0否)
    * √ 2 :数据库名、表名、字段名必须使用小写, mysql在linux下区分大小写
    * √ 3 :表名使用单数
    * √ 4 :禁用保留字, 如desc range match...
    * √ 5 :主键索引pk_xxx, 唯一索引uk_xxx，普通索引idx_xxx
    * √ 6 :小数类型decimal, 禁止使用float和double（存在精度损失问题）
    * √ 7 :若存储的字符串长度几乎相等, 则应使用char定长字符串类型
    * √ 8 :varchar可变长字符串, 不预先分配存储空间, 长度不要超过5000
    * √!9 :表必备三字段:
        * id           :主键, unsigned bigint, 单表时自增、步长为1
        * gmt_create   :date_time类型, 主动创建
        * gmt_modified :date_time类型, 被动更新
    * √ 10:表的命名：业务名称_表的作用
    * √ 11:库名与应用名一致
    * √ 12:当修改字段含义或对字段表示的状态追加时, 需更新字段注释
    * √ 13:适当冗余: 不是频繁修改的字段, 冗余可以避免关联查询
                    如图片类目使用频率高, 字段长度短, 名称基本不变, 可以冗余存储 
    * ? 14:单表行数超过500万行或单表超过2GB时, 才推荐进行分库分表
    * √ 15: 设置合适的字符存储长度            字节  表示范围
       * unsigned tinyint  :   1    0~255
       * unsigned smallint :   2    0~65535
       * unsigned int      :   4    0~2^32
       * unsigned bigint   :   8    0~2^64
#### 索引规范
    * √ ps:必须为主键创建主键索引
    * √!1 :业务上具有唯一特性的字段，必须建成唯一索引
    * ? 2 :尽量少用join, 注意索引注意性能
    * √ 3 :在varchar字段建立索引，指定长度，没有必要全字段建立
    * √ 4 :索引使用B-Tree最左前缀匹配特性，严禁左模糊
    * ? 5 :order by时, 注意索引有序性
    * ? 6 :利用覆盖索引进行查询, 避免回表
    * ? 7 :利用延迟关联或者子查询优化超多分页场景
    * √!8 :SQL性能优化的目标: 至少要达到range, 要求是ref, 最好是consts
        * range  :对索引进行范围检索
        * ref    :使用普通的索引
        * consts :单表中最多只有一个匹配行(pk 或 uk)
    * √ 9 :建立组合索引时，区分度最高的在最左边 where a=? and b=?
    * √ 9 :如存在非等号和等号，则应等号前置 where b=? and a>?
    * √ 10:  
        * 不要宁滥勿缺 不要一个查询就要建一个索引
        * 不要宁缺毋滥 索引的开销相对较小，在频繁字段建立索引
        * 不要抵制唯一索引
    * √ ps:  
        * 主键索引pk_xxx  :primary key
        * 唯一索引uk_xxx  :unique key
        * 普通索引idx_xxx :index
#### SQL语句
    * √ 1 :使用count(*)--SQL标准, 与数据库无关; 若使用count(列名)或count(常量), 不会统计NULL行
    * ? 2 :count(distinct col)计算该列除NULL外的不重复列数, 若出现NULL, 则不统计
    * ? 3 :当一列的值全为NULL, count(col)返回结果为0, sum(col)返回结果为NULL
    * √ 4 :ISNULL()判断是否为NULL
    * √ ps:NULL值与任何值的直接比较都为NULL
         * NULL<>NULL :
         * NULL-NULL  : 返回结果为NULL, 而不是true/false
         * NULL<>1    :
    * ? 5 :在代码中写分页查询逻辑时, 若count为0应直接返回, 避免执行后面的分页语句
    * √!6 :不得使用外键与级联, 一切外键概念必须在应用层解决
    * ? ps:如果更新user_id, 同时触发user_property中的user_id更新, 即为级联更新
          外键与级联更新适用于单机低并发, 不适合分布式, 高并发集群
          级联更新是强阻塞, 存在数据库更新风暴的风险, 外键影响数据插入速度
    * ? 7 :禁止使用存储过程
    * √ 8 :数据订正时(特别是删除、修改记录操作)时，要先select，避免出现误删除，确认无误再执行
    * ? 9 :in操作能避免就避免，实在避免不了，评估in后面的集合元素数量，控制在1000以内
    * √ 10:全球化，使用utf-8编码
        * SELECT LENGTH("数据库"); ==12
        * SELECT CHARCTER_LENGTH("数据库"); ==3
#### ORM映射
    * √ 1 :在表查询中，一律不要使用*作为查询的字段列表，需要哪些字段必须明确写明
         * 增加查询分析器解析成本
         * ? 增减字段容易与resultMap配置不一致
    * √ 2 :POJO类的boolean类型不能加is，
           数据库字段必须加is_
           要求在resultMap中进行字段和属性的映射
    * √ 3 :配置映射关系，使字段与DO解耦，方便维护
    * ? 4 :sql.xml 配置参数使用 #{}，#param# 不要使用${}，容易出现SQL注入
    * ? 5 :iBATIS ?
    * ? 6 不允许直接拿HashMap与Hashtable作为查询结果集的输出
    * √ 7 :更新记录时，必须同时更新记录对应的gmt_modified字段为当前时间
    * √ 8 :不要使用大而全的更新接口，不要更新无改动的字段
    * ? 9 :@Transactional事务 ?
    * ? 10:<isEqual> ?

------
### 创建admin表
    CREATE TABLE admin (
    admin_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(30) NOT NULL,
    admin_password VARCHAR(30) NOT NULL,
    admin_level VARCHAR(20) NOT NULL,
    admin_gmt_create DATETIME NOT NULL,
    admin_gmt_modified DATETIME NOT NULL
    )
    ---
    建立索引
    CREATE UNIQUE INDEX uk_admin_name
    ON admin(admin_name) 
    
------
### 创建user表
    CREATE TABLE user (
    user_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(30) NOT NULL,
    user_password VARCHAR(30) NOT NULL,
    user_level VARCHAR(30) NOT NULL,
    user_gmt_create DATETIME NOT NULL,
    user_gmt_modified DATETIME NOT NULL
    )
    ---
    建立索引
    CREATE UNIQUE INDEX uk_user_name
    ON user(user_name) 
        
------
### 创建user_property表
    CREATE TABLE user_property (
    user_id INT(6) UNSIGNED PRIMARY KEY,
    property_nickname VARCHAR(30),
    property_signature VARCHAR(50),
    property_sex VARCHAR(10),
    property_email VARCHAR(30),
    property_location VARCHAR(30),
    property_birthday DATE,
    property_gmt_create DATETIME NOT NULL,
    property_gmt_modified DATETIME NOT NULL
    )

------
### 创建user_icon表
    CREATE TABLE user_icon (
    user_id INT(6) UNSIGNED PRIMARY KEY,
    icon_path VARCHAR(200) NOT NULL,
    icon_gmt_create DATETIME NOT NULL,
    icon_gmt_modified DATETIME NOT NULL
    )

------
### 创建image表
    CREATE TABLE image (
    image_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    image_text VARCHAR(200),
    image_path VARCHAR(200),
    is_deleted TINYINT(1) UNSIGNED NOT NULL,
    user_id INT(6) UNSIGNED NOT NULL,
    class_id INT(6) UNSIGNED NOT NULL,
    image_gmt_create DATETIME NOT NULL,
    image_gmt_modified DATETIME NOT NULL
    )
    ---
    建立索引
    CREATE INDEX idx_user_id
    ON image(user_id) 
    CREATE INDEX idx_is_deleted
    ON image(is_deleted) 
    CREATE INDEX idx_class_id
    ON image(class_id) 
    
------
### 创建image_class
    CREATE TABLE image_class (
    image_class_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    image_class_name VARCHAR(20),
    image_class_desc VARCHAR(200),
    class_gmt_create DATETIME NOT NULL,
    class_gmt_modified  DATETIME NOT NULL
    )    

------
### 创建image_feature
    CREATE TABLE image_feature (
    image_id INT(6) UNSIGNED PRIMARY KEY,
    image_feature VARCHAR(2000),
    feature_gmt_create DATETIME NOT NULL,
    feature_gmt_modified  DATETIME NOT NULL
    )

------
### 创建diary表
    CREATE TABLE diary (
    diary_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    diary_name VARCHAR(200) NOT NULL,
    diary_text VARCHAR(2000) NOT NULL,
    is_deleted TINYINT(1) UNSIGNED NOT NULL,
    user_id INT(6) UNSIGNED NOT NULL,
    diary_gmt_create DATETIME NOT NULL,
    diary_gmt_modified DATETIME NOT NULL
    )
    ---
    建立索引
    CREATE UNIQUE INDEX uk_diary_name
    ON diary(diary_name)
    CREATE INDEX idx_user_id
    ON diary(user_id)
    CREATE INDEX idx_is_deleted
    ON diary(is_deleted) 
        
## SQL操作

------
### 管理员
#### 注册管理员账号
    1.验证此账号是否存在
    select count(admin_name) from admin where admin_name = ?
---   
    2.插入数据
    INSERT INTO admin(admin_name,admin_password,admin_level,admin_gmt_create,admin_gmt_modified)
    VALUES(?,?,?,?,?)
---    
    Demo: 
    INSERT INTO admin(admin_name,admin_password,admin_level,admin_gmt_create,admin_gmt_modified)
    VALUES('ten','123456','admin','2018-01-01 00:00:00','2018-01-01 00:00:00')   
    INSERT INTO admin(admin_name,admin_password,admin_level,admin_gmt_create,admin_gmt_modified)
    VALUES('admin','123456','admin','2018-01-01 00:00:00','2018-01-01 00:00:00')
    +----------+------------+----------------+-------------+---------------------+---------------------+
    | admin_id | admin_name | admin_password | admin_level | admin_gmt_create    | admin_gmt_modified  |
    +----------+------------+----------------+-------------+---------------------+---------------------+
    |        1 | ten        | 123456         | admin       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |        2 | admin      | 123456         | admin       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    +----------+------------+----------------+-------------+---------------------+---------------------+
#### 验证管理员登录
    1.判断用户是否存在
    select count(admin_name) from admin where admin_name = ?
---    
    Demo:
    select count(admin_name) from admin where admin_name = 'ten'
---    
    2.判断密码是否正确 以及 同时获取level信息(用户输错密码的概率较小,不用二次获取level)
    select admin_password,admin_level from admin where admin_name = ?     
---    
    Demo:
    select admin_password,admin_level from admin where admin_name = 'ten'    
    
------
### 用户
#### 注册用户
    1.验证此账号是否存在
    select count(user_name) from user where user_name = ?
    2.插入数据
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES(?,?,?,?,?)
---
    Demo: 
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES('one','123456','user','2018-01-01 00:00:00','2018-01-01 00:00:00')   
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES('two','123456','user','2018-01-01 00:00:00','2018-01-01 00:00:00')
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES('three','123456','user','2018-01-01 00:00:00','2018-01-01 00:00:00')
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES('four','123456','user','2018-01-01 00:00:00','2018-01-01 00:00:00')
    INSERT INTO user(user_name,user_password,user_level,user_gmt_create,user_gmt_modified)
    VALUES('five','123456','user','2018-01-01 00:00:00','2018-01-01 00:00:00')
    +---------+-----------+---------------+------------+---------------------+---------------------+
    | user_id | user_name | user_password | user_level | user_gmt_create     | user_gmt_modified   |
    +---------+-----------+---------------+------------+---------------------+---------------------+
    |       1 | one       | 123456        | user       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |       2 | two       | 123456        | user       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |       3 | three     | 123456        | user       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |       4 | four      | 123456        | user       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |       5 | five      | 123456        | user       | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    +---------+-----------+---------------+------------+---------------------+---------------------+
#### 用户登录
    1.判断用户是否存在
    select count(user_name) from user where user_name = ?
---    
    Demo:
    select count(user_name) from user where user_name = 'ten'
---    
    2.判断密码是否正确 以及 同时获取level信息(用户输错密码的概率较小,不用二次获取level)
    select user_password,user_level from user where user_name = ?     
---    
    Demo:
    select admin_password,admin_level from admin where admin_name = 'ten'    
    
------
### 图片
#### 图片插入
    INSERT INTO image(image_text,image_path,is_deleted,user_id,class_id,image_gmt_create,image_gmt_modified)
    VALUES(?,?,?,?,?,?,?)
---
    Demo:
    INSERT INTO image(image_text,image_path,is_deleted,user_id,class_id,image_gmt_create,image_gmt_modified)
    VALUES
    ('lifecat01','/usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image1.jpg',
    1,1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    
    INSERT INTO image(image_text,image_path,is_deleted,user_id,class_id,image_gmt_create,image_gmt_modified)
    VALUES
    ('lifecat02','/usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image2.jpg',
    1,1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    
    INSERT INTO image(image_text,image_path,is_deleted,user_id,class_id,image_gmt_create,image_gmt_modified)
    VALUES
    ('lifecat03','/usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image3.jpg',
    1,1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    +----------+------------+---------------------------------------------------------------------------------+------------+---------+----------+---------------------+---------------------+
    | image_id | image_text | image_path                                                                      | is_deleted | user_id | class_id | image_gmt_create    | image_gmt_modified  |
    +----------+------------+---------------------------------------------------------------------------------+------------+---------+----------+---------------------+---------------------+
    |        1 | lifecat01  | /usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image1.jpg |          1 |       1 |        1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |        2 | lifecat02  | /usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image2.jpg |          1 |       1 |        1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |        3 | lifecat03  | /usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/image/ten/1/image3.jpg |          1 |       1 |        1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    +----------+------------+---------------------------------------------------------------------------------+------------+---------+----------+---------------------+---------------------+    
#### 图片更新文本内容
    UPDATE image(image_id,image_text,image_,) VALUES(?,?,?,?,?)
    
#### 图片路径及类别更新
    UPDATE image(image_path,class_id,image_gmt_modified) VALUES(?,?,?) where image_id = ?
    
#### 图片删除
    DELETE from image where image_id = ?
    
####图片单个查询
    SELECT image_id,image_text,image_path,image_gmt_create from image where image_id = ? and is_deleted = 1
    
#### 图片集合查询
    SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = ? and is_deleted = 1

#### 图片分类集合查询
    SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = ? and class_id = ? and is_deleted = 1

