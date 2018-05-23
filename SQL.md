## 创建数据库

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
        
### 创建user_icon表
    CREATE TABLE user_icon (
    user_id INT(6) UNSIGNED PRIMARY KEY,
    icon_path VARCHAR(200) NOT NULL,
    icon_gmt_create DATETIME NOT NULL,
    icon_gmt_modified DATETIME NOT NULL
    )
   
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
    
### 创建image_class
    CREATE TABLE image_class (
    image_class_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    image_class_name VARCHAR(20),
    image_class_desc VARCHAR(200),
    class_gmt_create DATETIME NOT NULL,
    class_gmt_modified  DATETIME NOT NULL
    )    
    
### 创建image_feature
    CREATE TABLE image_feature (
    image_id INT(6) UNSIGNED PRIMARY KEY,
    image_feature VARCHAR(2000),
    feature_gmt_create DATETIME NOT NULL,
    feature_gmt_modified  DATETIME NOT NULL
    )
      
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
        
## DAO实例

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

