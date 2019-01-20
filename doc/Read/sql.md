## 数据库SQL

---
### 数据库分析

---
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
### 创建test表
    CREATE TABLE test (
    test_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    test_name VARCHAR(20) NOT NULL,
    test_text VARCHAR(200),
    test_gmt_create DATETIME NOT NULL,
    test_gmt_modified DATETIME NOT NULL
    )
    ---
    建立索引
    CREATE UNIQUE INDEX uk_test_name
    ON test(test_name)

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
    
    +-------------------+-----------------+------+-----+---------+----------------+
    | Field             | Type            | Null | Key | Default | Extra          |
    +-------------------+-----------------+------+-----+---------+----------------+
    | user_id           | int(6) unsigned | NO   | PRI | NULL    | auto_increment |
    | user_name         | varchar(30)     | NO   | UNI | NULL    |                |
    | user_password     | varchar(30)     | NO   |     | NULL    |                |
    | user_level        | varchar(30)     | NO   |     | NULL    |                |
    | user_gmt_create   | datetime        | NO   |     | NULL    |                |
    | user_gmt_modified | datetime        | NO   |     | NULL    |                |
    +-------------------+-----------------+------+-----+---------+----------------+    
    
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

    +-----------------------+-----------------+------+-----+---------+-------+
    | Field                 | Type            | Null | Key | Default | Extra |
    +-----------------------+-----------------+------+-----+---------+-------+
    | user_id               | int(6) unsigned | NO   | PRI | NULL    |       |
    | property_nickname     | varchar(30)     | YES  |     | NULL    |       |
    | property_signature    | varchar(50)     | YES  |     | NULL    |       |
    | property_sex          | varchar(10)     | YES  |     | NULL    |       |
    | property_email        | varchar(30)     | YES  |     | NULL    |       |
    | property_location     | varchar(30)     | YES  |     | NULL    |       |
    | property_birthday     | date            | YES  |     | NULL    |       |
    | property_gmt_create   | datetime        | NO   |     | NULL    |       |
    | property_gmt_modified | datetime        | NO   |     | NULL    |       |
    +-----------------------+-----------------+------+-----+---------+-------+
    
------
### 创建user_icon表
    CREATE TABLE user_icon (
    user_id INT(6) UNSIGNED PRIMARY KEY,
    icon_path VARCHAR(200) NOT NULL,
    icon_gmt_create DATETIME NOT NULL,
    icon_gmt_modified DATETIME NOT NULL
    )

    +-------------------+-----------------+------+-----+---------+-------+
    | Field             | Type            | Null | Key | Default | Extra |
    +-------------------+-----------------+------+-----+---------+-------+
    | user_id           | int(6) unsigned | NO   | PRI | NULL    |       |
    | icon_path         | varchar(200)    | NO   |     | NULL    |       |
    | icon_gmt_create   | datetime        | NO   |     | NULL    |       |
    | icon_gmt_modified | datetime        | NO   |     | NULL    |       |
    +-------------------+-----------------+------+-----+---------+-------+

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
    
    +--------------------+---------------------+------+-----+---------+----------------+
    | Field              | Type                | Null | Key | Default | Extra          |
    +--------------------+---------------------+------+-----+---------+----------------+
    | image_id           | int(6) unsigned     | NO   | PRI | NULL    | auto_increment |
    | image_text         | varchar(200)        | YES  |     | NULL    |                |
    | image_path         | varchar(200)        | YES  |     | NULL    |                |
    | is_deleted         | tinyint(1) unsigned | NO   | MUL | NULL    |                |
    | user_id            | int(6) unsigned     | NO   | MUL | NULL    |                |
    | class_id           | int(6) unsigned     | NO   | MUL | NULL    |                |
    | image_gmt_create   | datetime            | NO   |     | NULL    |                |
    | image_gmt_modified | datetime            | NO   |     | NULL    |                |
    +--------------------+---------------------+------+-----+---------+----------------+
    
------
### 创建image_class
    CREATE TABLE image_class (
    image_class_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    image_class_name VARCHAR(20),
    image_class_desc VARCHAR(200),
    class_gmt_create DATETIME NOT NULL,
    class_gmt_modified  DATETIME NOT NULL
    )    

    +--------------------+-----------------+------+-----+---------+----------------+
    | Field              | Type            | Null | Key | Default | Extra          |
    +--------------------+-----------------+------+-----+---------+----------------+
    | image_class_id     | int(6) unsigned | NO   | PRI | NULL    | auto_increment |
    | image_class_name   | varchar(20)     | YES  |     | NULL    |                |
    | image_class_desc   | varchar(200)    | YES  |     | NULL    |                |
    | class_gmt_create   | datetime        | NO   |     | NULL    |                |
    | class_gmt_modified | datetime        | NO   |     | NULL    |                |
    +--------------------+-----------------+------+-----+---------+----------------+

------
### 创建image_feature
    CREATE TABLE image_feature (
    image_id INT(6) UNSIGNED PRIMARY KEY,
    image_feature VARCHAR(2000),
    feature_gmt_create DATETIME NOT NULL,
    feature_gmt_modified  DATETIME NOT NULL
    )

    +----------------------+-----------------+------+-----+---------+-------+
    | Field                | Type            | Null | Key | Default | Extra |
    +----------------------+-----------------+------+-----+---------+-------+
    | image_id             | int(6) unsigned | NO   | PRI | NULL    |       |
    | image_feature        | varchar(2000)   | YES  |     | NULL    |       |
    | feature_gmt_create   | datetime        | NO   |     | NULL    |       |
    | feature_gmt_modified | datetime        | NO   |     | NULL    |       |
    +----------------------+-----------------+------+-----+---------+-------+

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
        
    +--------------------+---------------------+------+-----+---------+----------------+
    | Field              | Type                | Null | Key | Default | Extra          |
    +--------------------+---------------------+------+-----+---------+----------------+
    | diary_id           | int(6) unsigned     | NO   | PRI | NULL    | auto_increment |
    | diary_name         | varchar(200)        | NO   | UNI | NULL    |                |
    | diary_text         | varchar(2000)       | NO   |     | NULL    |                |
    | is_deleted         | tinyint(1) unsigned | NO   | MUL | NULL    |                |
    | user_id            | int(6) unsigned     | NO   | MUL | NULL    |                |
    | diary_gmt_create   | datetime            | NO   |     | NULL    |                |
    | diary_gmt_modified | datetime            | NO   |     | NULL    |                |
    +--------------------+---------------------+------+-----+---------+----------------+    
        
------
## SQL操作

------
### admin
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
### user
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
---
    
------
### user_property    
#### 插入用户资料
    INSERT INTO user_property(user_id,property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create,property_gmt_modified)
    VALUES(?,?,?,?,?,?,?,?,?)
---
    Demo: 
    INSERT INTO user_property(user_id,property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create,property_gmt_modified)
    VALUES('1','one','this is one','man','one@qq.com','wuxi','2000-01-01','2018-01-01 00:00:00','2018-01-01 00:00:00')
    INSERT INTO user_property(user_id,property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create,property_gmt_modified)
    VALUES('2','two','this is two','man','two@qq.com','wuxi','2000-01-01','2018-01-01 00:00:00','2018-01-01 00:00:00')
    INSERT INTO user_property(user_id,property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create,property_gmt_modified)
    VALUES('3','three','this is three','woman','three@qq.com','wuxi','2000-01-01','2018-01-01 00:00:00','2018-01-01 00:00:00') 
    +---------+-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+-----------------------+
    | user_id | property_nickname | property_signature | property_sex | property_email | property_location | property_birthday | property_gmt_create | property_gmt_modified |
    +---------+-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+-----------------------+
    |       1 | one               | this is one        | man          | one@qq.com     | wuxi              | 2000-01-01        | 2018-01-01 00:00:00 | 2018-01-01 00:00:00   |
    |       2 | two               | this is two        | man          | two@qq.com     | wuxi              | 2000-01-01        | 2018-01-01 00:00:00 | 2018-01-01 00:00:00   |
    |       3 | three             | this is three      | woman        | three@qq.com   | wuxi              | 2000-01-01        | 2018-01-01 00:00:00 | 2018-01-01 00:00:00   |
    +---------+-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+-----------------------+
#### 查询用户资料
    SELECT property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create from user_property where user_id = ?
---
    Demo:
    SELECT property_nickname,property_signature,property_sex,property_email,property_location,property_birthday,property_gmt_create from user_property where user_id = '1';
    +-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+
    | property_nickname | property_signature | property_sex | property_email | property_location | property_birthday | property_gmt_create |
    +-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+
    | one               | this is one        | man          | one@qq.com     | wuxi              | 2000-01-01        | 2018-01-01 00:00:00 |
    +-------------------+--------------------+--------------+----------------+-------------------+-------------------+---------------------+
    
------
### user_icon    
#### 插入
    INSERT INTO user_icon(user_id,icon_path,icon_gmt_create,icon_gmt_modified)
    VALUES(?,?,?,?)
---
    Demo:
    INSERT INTO user_icon(user_id,icon_path,icon_gmt_create,icon_gmt_modified)
    VALUES('1','D:\Java\lifecatweb\src\main\webapp\image\one\icon\icon.jpg','2018-01-01 00:00:00','2018-01-01 00:00:00')
    +---------+---------------------------------------------------+---------------------+---------------------+
    | user_id | icon_path                                         | icon_gmt_create     | icon_gmt_modified   |
    +---------+---------------------------------------------------+---------------------+---------------------+
    |       1 | D:Javalifecatwebsrcmainwebappimageoneiconicon.jpg | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    +---------+---------------------------------------------------+---------------------+---------------------+
#### 查询
    SELECT icon_path FROM user_icon where user_id = ?
#### 更新
    UPDATE user_icon set icon_path = ?,icon_gmt_modified = ? where user_id = ?
    
------
### 图片image
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
#### 图片文本内容更新
    UPDATE image set image_text = ? where image_id = ?
    
#### 图片路径更新
    UPDATE image set image_path = ?,image_gmt_modified = ? where image_id = ?
    
#### 图片删除
    UPDATE image set is_deleted = '0' where image_id = ?

####图片单个查询
    SELECT image_text,image_path,image_gmt_create from image where image_id = ? and is_deleted = '1'
    
#### 图片集合查询
    SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = ? and is_deleted = '1'

#### 图片分类集合查询
    SELECT image_id,image_text,image_path,image_gmt_create from image where user_id = ? and class_id = ? and is_deleted = '1'

------
### 图片类别image_class
#### TODO

------
### 图片特征image_feature
#### TODO

------
### 日记diary
#### 日记插入
    INSERT INTO diary(diary_name,diary_text,is_deleted,user_id,diary_gmt_create,diary_gmt_modified)
    VALUES(?,?,?,?,?,?)
---
    Demo:
    INSERT INTO diary(diary_name,diary_text,is_deleted,user_id,diary_gmt_create,diary_gmt_modified)
    VALUES
    ('diary01','this is diary01',
    1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    
    INSERT INTO diary(diary_name,diary_text,is_deleted,user_id,diary_gmt_create,diary_gmt_modified)
    VALUES
    ('diary02','this is diary02',
    1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    
    INSERT INTO diary(diary_name,diary_text,is_deleted,user_id,diary_gmt_create,diary_gmt_modified)
    VALUES
    ('diary03','this is diary03',
    1,1,'2018-01-01 00:00:00','2018-01-01 00:00:00')
    +----------+------------+-----------------+------------+---------+---------------------+---------------------+
    | diary_id | diary_name | diary_text      | is_deleted | user_id | diary_gmt_create    | diary_gmt_modified  |
    +----------+------------+-----------------+------------+---------+---------------------+---------------------+
    |        1 | diary01    | this is diary01 |          1 |       1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |        2 | diary02    | this is diary02 |          1 |       1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    |        3 | diary03    | this is diary03 |          1 |       1 | 2018-01-01 00:00:00 | 2018-01-01 00:00:00 |
    +----------+------------+-----------------+------------+---------+---------------------+---------------------+#### 图片文本内容更新
#### 日记文本内容更新    
    UPDATE diary set diary_text = ?,diary_gmt_modified = ? where diary_id = ?
    
#### 日记删除
    UPDATE diary set is_delete = '0',diary_gmt_modified = ? where diary_id = ?

####日记单个查询
    SELECT diary_name,diary_text,diary_gmt_create from diary where diary_id = ? and is_deleted = '1'
    
#### 日记集合查询
    SELECT diary_id,diary_name,diary_text,diary_gmt_create from diary where user_id = ? and is_deleted = '1'
