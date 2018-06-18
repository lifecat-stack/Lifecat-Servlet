## 数据库设计

### mysql数据库 '__lifecat__'

   |数据表名            |说明
   |---                |---
   | admin             | 管理员账号
   |                   |
   | user              | 用户账号
   | user_property     | 用户个人资料
   | user_icon         | 用户头像信息
   |                   |
   | image             | 图片信息
   | image_class       | 图片类别
   | image_feature     | 图片特征向量
   |                   |
   | diary             | 日记信息

------
### 数据库关系设计
                 用户资料/头像
                      ^
                      |
                      | 1
                      | :
                      | 1
                      |
                      v
    管理员 < ------ > 用户 < ------ > 日记
             N:N      ^      1:N
                      |
                      | 1
                      | :
                      | N
                      |
                      v
                     图片 < ------ > 图片类别
                             1:1

------
### 数据库模块设计
    管理员模块: admin
    属性: 管理员ID、用户名、密码...
    唯一表示: ID、用户名
    存储特点: 永久储存
---
    用户模块: user
    属性: 用户ID、用户名、密码、用户资料...
    唯一表示: ID、用户名
    存储特点: 永久储存
---
    图片模块: image
    属性: 用户ID、图片ID、图片日期、图片类别、图片描述...
    唯一表示: 图片ID
    存储特点: 永久储存
---
    日记模块: diary
    属性: 用户ID、日记ID、日记日期、日记名称、日记内容...
    唯一表示: 日记ID
    存储特点: 永久储存
    
------
### 数据库表设计

    管理员表: admin
    
    注册: 插入admin对象，返回admin_id
    登录: 根据索引uk_admin_name进行查询
    查询是否存在: 根据uk_admin_name进行查询
    修改: 根据主键admin_id，进行更新
    
    +--------------------+-----------------+------+-----+---------+----------------+
    | Field              | Type            | Null | Key | Default | Extra          |
    +--------------------+-----------------+------+-----+---------+----------------+
    | admin_id           | int(6) unsigned | NO   | PRI | NULL    | auto_increment |
    | admin_name         | varchar(30)     | NO   | UNI | NULL    |                |
    | admin_password     | varchar(30)     | NO   |     | NULL    |                |
    | admin_level        | varchar(20)     | NO   |     | NULL    |                |
    | admin_gmt_create   | datetime        | NO   |     | NULL    |                |
    | admin_gmt_modified | datetime        | NO   |     | NULL    |                |
    +--------------------+-----------------+------+-----+---------+----------------+
------------------------------------------------------------------------
    用户账号表: user
    
    注册: 插入user对象，返回user_id
    登录: 根据索引uk_user_name进行查询
    查询存在: 根据user_name进行查询
    修改: 根据主键user_id，进行更新
    
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
------------------------------------------------------------------------
    用户信息表: user_property
    
    设置资料: 根据主键user_id，插入user_property对象
    获取资料: 根据主键user_id进行查询
    
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
------------------------------------------------------------------------    
    用户头像表: user_icon
    
    插入: 根据主键user_id进行插入
    查询: 根据主键user_id进行查询
    
    +-------------------+-----------------+------+-----+---------+-------+
    | Field             | Type            | Null | Key | Default | Extra |
    +-------------------+-----------------+------+-----+---------+-------+
    | user_id           | int(6) unsigned | NO   | PRI | NULL    |       |
    | icon_path         | varchar(200)    | NO   |     | NULL    |       |
    | icon_gmt_create   | datetime        | NO   |     | NULL    |       |
    | icon_gmt_modified | datetime        | NO   |     | NULL    |       |
    +-------------------+-----------------+------+-----+---------+-------+
------------------------------------------------------------------------
    图片信息表: image
    
    上传/插入: 根据user_id进行插入，主键image_id，返回image_id
    查询/获取所有图片: 根据索引idx_user_id并且idx_is_deleted=1查询同一用户的所有image，并排序
    查询/获取单个图片: 根据主键image_id并且idx_is_deleted=1进行查询，返回image对象
    排序: order by 主键image_id
    删除: 根据image_id，设置isdelete=0
    
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
------------------------------------------------------------------------    
    图片类别描述表: image_class
    
    插入: 插入image_class_name，返回id
    获取: 根据image_class_id获取
    
    +--------------------+-----------------+------+-----+---------+----------------+
    | Field              | Type            | Null | Key | Default | Extra          |
    +--------------------+-----------------+------+-----+---------+----------------+
    | image_class_id     | int(6) unsigned | NO   | PRI | NULL    | auto_increment |
    | image_class_name   | varchar(20)     | YES  |     | NULL    |                |
    | image_class_desc   | varchar(200)    | YES  |     | NULL    |                |
    | class_gmt_create   | datetime        | NO   |     | NULL    |                |
    | class_gmt_modified | datetime        | NO   |     | NULL    |                |
    +--------------------+-----------------+------+-----+---------+----------------+
------------------------------------------------------------------------
    机器学习-图片特征向量: image_feature
    
    上传/插入: 根据image_id，插入信息
    获取: 根据image_id，获取对象
    
    +----------------------+-----------------+------+-----+---------+-------+
    | Field                | Type            | Null | Key | Default | Extra |
    +----------------------+-----------------+------+-----+---------+-------+
    | image_id             | int(6) unsigned | NO   | PRI | NULL    |       |
    | image_feature        | varchar(2000)   | YES  |     | NULL    |       |
    | feature_gmt_create   | datetime        | NO   |     | NULL    |       |
    | feature_gmt_modified | datetime        | NO   |     | NULL    |       |
    +----------------------+-----------------+------+-----+---------+-------+
------------------------------------------------------------------------
    用户日记表: diary
    
    上传/插入: 插入diary对象，返回diary_id
    获取集合: 根据索引idx_user_id并且idx_is_deleted=1进行查询
    搜索单篇: 根据索引idx_user_id和索引idx_diary_name并且idx_is_deleted=1进行查询
    排序: order by 主键diary_id
    
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
