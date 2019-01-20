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
        
______
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
