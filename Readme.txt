/**
  ******************************************************************************
  * @desc    智能成长相册网站lifecat
  * @author  ten
  * @version V2.0.0
  * @date    2018-05
  * @brief   基于MVC的Javaweb网站开发
  ******************************************************************************
  * @访问链接
  *
  * 官网主页 :http://www.lifecat.club
  * 相册主页 :http://111.230.244.153:8080/lifecatweb
  *
  ******************************************************************************
  * @使用技术
  *
  * 前端 :Html CSS JavaScript
  * 前端框架 :bootstrap jQuery
  *
  * 后端 :jsp servlet jdbc
  * 后端框架 :MVC-Model2 sturts设计理念
  *
  * 设计模式 :构建者模式 静态工厂模式 单例模式
  *
  * 单元测试 :Junit4
  *
  * 数据库 :MySql-mariadb
  *
  ******************************************************************************
  * @Web目录
  *
  * web
  * |
  * |-include
  * | |
  * | |-home
  * | | |
  * | | |-homePage.jsp   //用户主页body内容部件
  * | |
  * | |-footer.jsp       //页脚部件
  * | |
  * | |-header.jsp       //页眉部件
  * | |
  * | |-top.jsp          //页面标题栏部件
  * |
  * |-WEB-INF
  * | |
  * | |-imageshow.jsp    //用户图片展示界面
  * | |
  * | |-imageshow2.jsp   //用户分类图片展示界面
  * | |
  * | |-updiary.jsp      //上传日记
  * | |
  * | |-upimage.jsp      //上传图片
  * | |
  * | |-userhome.jsp     //用户主页
  * |
  * |-index.jsp          //登录/注册界面
  *
  ******************************************************************************
  * @Java目录
  *
  * src
  * |
  * |-main
  * | |
  * | |-android       //接收Android端请求, 并返回请求结果
  * | |
  * | |-bean          //对应于数据库表结构, 采用构建者模式生成
  * | |
  * | |-dao           //DAO层, 执行jdbc数据库交互, DAOModel层通过静态工厂获取
  * | |
  * | |-daomodel      //DAOModel层, DAO层的抽象逻辑操作, Model层通过静态工厂获取
  * | |
  * | |-filter        //过滤器, 对所有请求执行Encoding过滤, 对*.do请求执行Form过滤
  * | |
  * | |-form          //表单验证, 对相应表单执行过滤, 确保格式编码等
  * | |
  * | |-python        //通过java call shell方式, 调用本地python脚本, 执行机器学习操作
  * | |
  * | |-service       //Controller层, 通过请求内容, 调用相应Model, 转发到Model并获取返回结果
  * | |
  * | |-servicemodel  //Model层, 执行具体业务逻辑, 并且通过try-catch处理底层抛出异常, 设置内容到Session
  * | |
  * | |-util          //工具类, 多采用单例模式, 包括时间类, 连接类, 图片写入操作, 主机配置等
  * |
  * |-test
  *   |
  *   |-Test          //单元测试
  *
  ******************************************************************************
  * @请求流程分析
  *
  *  用户请求
  *   |          根据result对象, 转发到对应视图, 视图层通过Session访问请求对象
  *   |    +----------------------------------------------------------------+
  *   |    |                                                                |
  *   V    v                                      Form表单验证          控制器: 转发请求
  *  +------+                                         |                 +----------+
  *  | view |                                         v                 |controller|
  *  +------+  'action.do'      映射      web.xml    过滤器               +----------+
  *  web视图层 ----------- > url-pattern --------- > filter --------- > ActionServlet <---+
  *    jsp                                                                  |            |
  *                                                                         | 根据.do     | 返回模型执行结果
  *                                               返回数据库处理结果           | 转发请求     | ModelResult对象
  *                                            +-------------------+        | 调用Model   | 执行相应转发
  *                                            |                   |        |            |
  *             jdbc                           |                   v        v            |
  *     DB < ----------- DAO < ----------- DAOModel < ----------- ServiceModel ----------+
  *     数据库          数据库访问层        处理DAO层具体逻辑            +---------+
  *     |                 |                    ^                   |  model  | ----------> 将获取的结果对象
  *     |                 |                    |                   +---------+             设置到Session
  *     |                 +--------------------+              模型层: 处理具体业务逻辑
  *     v                       返回Bean对象
  *  Bean对象对应数据表
  *
  ******************************************************************************
  */

/**
  +----------------------------------------------------------------------------+
  |                                版本管理                                     |
  +----------------------------------------------------------------------------+
  */

version1.1
    --添加了logger
    --添加了图片读取
    --修改了HOST接口

version1.2
    --添加了智能分类页面
    --修复了bug

version1.3.1
    --单例模式重构MyDate
    --构建器模式重构Bean
    --重写了User的hashCode计算,Image的hashCode计算
    --覆盖了tostring方法

version1.3.2
    --Image类实现了comparable接口
    --HOST实现了标记接口
    --重构了DAO的SQL查询(单条查询->多条查询)
    //TODO
    --设计方法签名
    --参数检查
    --枚举类改进

/**
  +----------------------------------------------------------------------------+
  |                                数据库设计                                    |
  +----------------------------------------------------------------------------+
  */

=>数据库范式:
    1NF - First Normal Form 符合1NF的关系中的每个属性都是原子的不可再分。
    2NF - Second Normal Form 满足1NF，数据库表中的每列都完全依赖于主键。
    3NF - Third Normal Form 满足2NF，要求一个数据库表中不包含已在其它表中已包含的非主关键字信息。
    BCNF - Boyce–Codd Normal Form 满足3NF，主属性内部不能部分或传递依赖

=>数据库关系:
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
=>数据库模块:
    管理员模块: admin
    属性: 管理员ID、用户名、密码...
    唯一表示: ID、用户名
    存储特点: 永久储存

    用户模块: user
    属性: 用户ID、用户名、密码、用户资料...
    唯一表示: ID、用户名
    存储特点: 永久储存

    图片模块: image
    属性: 用户ID、图片ID、图片日期、图片类别、图片描述...
    唯一表示: 图片ID
    存储特点: 永久储存

    日记模块: diary
    属性: 用户ID、日记ID、日记日期、日记名称、日记内容...
    唯一表示: 日记ID
    存储特点: 永久储存

=>《Java开发手册》建表规约:
    ○5.1.1 字段若非负，必须是unsigned
    ○5.1.1 表达是否概念，必须使用is_xxx方式，数据类型为unsigned tinyint(1是，0否)
    ○5.1.2 数据库名、表名、字段名必须使用小写
    ○5.1.3 表名使用单数
    ○5.1.5 主键索引pk_xxx，唯一索引uk_xxx，普通索引idx_xxx
    ○5.1.6 小数类型decimal，禁止使用float和double（存在精度损失问题）

    ○5.1.7 若存储的字符串长度几乎相等，则应使用char定长字符串类型
    ○5.1.8 varchar可变长字符串，不预先分配存储空间，长度不要超过5000
    ○5.1.9 表必备三字段：
                       id           :主键, unsigned bigint, 单表时自增、步长为1
                       gmt_create   :date_time类型，主动创建
                       gmt_modified :date_time类型，被动更新
    ○5.1.10 表的命名：业务名称_表的作用
    ○5.1.13 适当冗余：不是频繁修改的字段，冗余可以避免关联查询
    ○5.1.15 设置合适的字符存储长度          字节  表示范围
                    unsigned tinyint  :   1    0~255
                    unsigned smallint :   2    0~65535
                    unsigned int      :   4    0~2^32
                    unsigned bigint   :   8    0~2^64

=>《Java开发手册》索引规范:
    ○ps 必须为主键创建主键索引
    ○5.2.1 业务上具有唯一特性的字段，必须建成唯一索引
    ○5.2.3 在varchar字段建立索引，指定长度，没有必要全字段建立
    ○5.2.4 索引使用B-Tree最左前缀匹配特性，严禁左模糊
    ○5.2.9 建立组合索引时，区分度最高的在最左边 where a=? and b=?
    ○5.2.9 如存在非等号和等号，则应等号前置 where b=? and a>?
    ○5.1.5 主键索引pk_xxx  :primary key
            唯一索引uk_xxx  :unique key
            普通索引idx_xxx :index

    ○不要宁滥勿缺 不要一个查询就要建一个索引
    ○不要宁缺毋滥 索引的开销相对较小，在频繁字段建立索引
    ○不要抵制唯一索引

=>数据库设计: lifecat

    +-------------------+
    | Tables_in_lifecat |
    +-------------------+
    | admin             | 管理员账号
    |                   |
    | user              | 用户账号
    | user_property     | 用户个人资料
    | user_icon         | 用户头像信息
    |                   |
    | image             | 图片信息
    | image_type        | 图片所属类别信息
    | image_class       | 图片类别
    | image_feature     | 图片特征向量
    |                   |
    | diary             | 日记信息
    +-------------------+

○管理员表: admin
    注册: 插入admin对象，返回admin_id
    登录: 根据索引uk_admin_name进行查询，返回user对象
    修改: 根据主键admin_id，进行更新
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | admin_id            | unsigned int| NO   | PRI | NULL    | AUTO  | 管理员ID, 主键索引. 自增长
    | admin_name          | varchar(50) | NO   |     | NULL    |       | 管理员用户名
    | uk_admin_name       | varchar(50) | NO   | UNQ | NULL    |       | 唯一索引: admin_name
    | admin_password      | varchar(50) | NO   |     | NULL    |       | 管理员密码
    | admin_level         | varchar(20) | NO   |     | NULL    |       | 管理员权限
    | admin_gmt_create    | datetime    | NO   |     | NULL    |       | 管理员创建时间
    | admin_gmt_modified  | datetime    | NO   |     | NULL    |       | 管理员修改时间
    +---------------------+-------------+------+-----+---------+-------+

------------------------------------------------------------------------

○用户账号表: user
    注册: 插入user对象，返回user_id
    登录: 根据索引uk_user_name进行查询，返回user对象
    修改: 根据主键user_id，进行更新
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | user_id             | unsigned int| NO   | PRI | NULL    | AUTO  | 用户ID, 主键索引, 自增长
    | user_name           | varchar(50) | NO   |     | NULL    |       | 用户账户名
    | uk_user_name        | varchar(50) | NO   | UNQ | NULL    |       | 索引: user_name
    | user_password       | varchar(50) | NO   |     | NULL    |       | 用户密码
    | user_gmt_create     | datetime    | NO   |     | NULL    |       | 用户注册时间
    | user_gmt_modified   | datetime    | NO   |     | NULL    |       | 用户账户修改时间
    +---------------------+-------------+------+-----+---------+-------+

○用户信息表: user_property
    设置资料: 根据主键user_id，插入user_property对象
    获取资料: 根据主键user_id进行查询
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | user_id             | unsigned int| NO   | PRI | NULL    |       | 用户ID, 主键索引. 关联user
    | property_nickname   | varchar(30) | YES  |     | NULL    |       | 用户昵称
    | property_signature  | varchar(50) | YES  |     | NULL    |       | 用户签名
    | property_email      | varchar(30) | YES  |     | NULL    |       | 用户邮箱
    | property_Location   | varchar(30) | YES  |     | NULL    |       | 用户地址
    | property_birthday   | unsigned int| YES  |     | NULL    |       | 用户生日
    | property_gmt_create | datetime    | NO   |     | NULL    |       | 用户第一次设置信息
    | property_gmt_modified|datetime    | NO   |     | NULL    |       | 用户修改信息时间
    +---------------------+-------------+------+-----+---------+-------+

○用户头像表: user_icon
    插入: 根据主键user_id进行插入
    查询: 根据主键user_id进行查询
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | user_id             | unsigned int| NO   | PRI | NULL    |       | 用户ID
    | icon_path           | varchar(200)| NO   |     | NULL    |       | 用户头像图片存储路径
    | icon_gmt_create     | datetime    | NO   |     | NULL    |       | 创建时间
    | icon_gmt_modified   | datetime    | NO   |     | NULL    |       | 修改时间
    +---------------------+-------------+------+-----+---------+-------+

------------------------------------------------------------------------

○图片信息表: image
    上传/插入: 根据user_id进行插入，主键image_id，返回image_id
    查询/获取所有图片: 根据索引idx_user_id并且idx_is_deleted=1查询同一用户的所有image，并排序
    查询/获取单个图片: 根据主键image_id并且idx_is_deleted=1进行查询，返回image对象
    排序: order by 主键image_id
    删除: 根据image_id，设置isdelete=0
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | image_id            | unsigned int| NO   | PRI | NULL    | AUTO  | 图片ID, 主键索引. 自增长
    | image_text          | varchar(200)| YES  |     | NULL    |       | 图片文本内容, 可为空
    | image_path          | varchar(200)| NO   |     | NULL    |       | 图片路径
    | is_deleted          | unsigned tinyint NO|     | NULL    |       | 图片是否删除 1是 0否
    | idx_is_deleted      | unsigned tinyint NO|     | NULL    |       | 索引: isdeleted
    | user_id             | unsigned int| NO   |     | NULL    |       | 所属user_id
    | idx_user_id         | unsigned int| NO   | IDX | NULL    |       | 索引: user_id
    | image_gmt_create    | datetime    | NO   |     | NULL    |       | 图片上传日期
    | image_gmt_modified  | datetime    | NO   |     | NULL    |       | 图片修改日期
    +---------------------+-------------+------+-----+---------+-------+

○图片类型关联表: image_type
    上传/插入: 根据返回的image_id，插入user_id和默认image_class
    获取分类图片: 根据索引idx_user_id和索引idx_image_class获取此类别的所有image_id
                然后根据image_id从image表中获取所有image对象
    插入/修改类别信息: 根据image_id，更新image_class
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | image_id            | unsigned int| NO   | PRI | NULL    |       | 图片ID
    | user_id             | unsigned int| NO   |     | NULL    |       | 图片所属user_id
    | idx_user_id         | unsigned int| NO   | IDX | NULL    |       | 索引: user_id
    | image_class         | unsigned int| NO   |     | NULL    |       | 图片所属类别id
    | idx_image_class     | unsigned int| NO   | IDX | NULL    |       | 索引: image_id
    | type_gmt_create     | datetime    | NO   |     | NULL    |       | 创建时间
    | type_gmt_modified   | datetime    | NO   |     | NULL    |       | 修改时间
    +---------------------+-------------+------+-----+---------+-------+

○图片类别描述表: image_class
    插入: 插入image_class_name，返回id
    获取: 根据image_class_id获取
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | image_class_id      | unsigned int| NO   | PRI | NULL    | AUTO  | 图片类别id
    | image_class_name    | varchar(20) | NO   |     | NULL    |       | 图片类别name
    | image_class_desc    | varchar(200)| YES  |     | NULL    |       | 图片类别描述
    | class_gmt_create    | datetime    | NO   |     | NULL    |       | 创建时间
    | class_gmt_modified  | datetime    | NO   |     | NULL    |       | 修改时间
    +---------------------+-------------+------+-----+---------+-------+

○机器学习-图片特征向量: image_feature
    上传/插入: 根据image_id，插入信息
    获取: 根据image_id，获取对象
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | image_id            | unsigned int| NO   | PRI | NULL    |       | 图片ID
    | image_class         | unsigned int| YES  |     | NULL    |       | 图片所属类别
    | image_feature_path  | varchar(200)| YES  |     | NULL    |       | 图片PCA之后的特征向量存储的路径
    | feature_gmt_create  | datetime    | NO   |     | NULL    |       | 创建时间
    | feature_gmt_modified| datetime    | NO   |     | NULL    |       | 修改时间
    +---------------------+-------------+------+-----+---------+-------+

------------------------------------------------------------------------

○用户日记表: diary
    上传/插入: 插入diary对象，返回diary_id
    获取集合: 根据索引idx_user_id并且idx_is_deleted=1进行查询
    搜索单篇: 根据索引idx_user_id和索引idx_diary_name并且idx_is_deleted=1进行查询
    排序: order by 主键diary_id
    +---------------------+-------------+------+-----+---------+-------+
    | Field               | Type        | Null | Key | Default | Extra |
    +---------------------+-------------+------+-----+---------+-------+
    | diary_id            | unsigned int| NO   | PRI | NULL    | AUTO  | 日记ID, 自增长
    | diary_name          | varchar(200)| NO   |     | NULL    |       | 日记名称
    | idx_diary_name      | varchar(200)| NO   | IDX | NULL    |       | 索引: diary_name
    | diary_text          | text        | NO   |     | NULL    |       | 日记内容
    | is_delete           | unsigned tinyint NO|     | NULL    |       | 日记是否删除
    | idx_is_delete       | unsigned tinyint NO| IDX | NULL    |       | 索引: 日记是否删除
    | user_id             | unsigned int| NO   |     | NULL    |       | 所属user_id
    | idx_user_id         | unsigned int| NO   | IDX | NULL    |       | 索引: user_id
    | diary_gmt_create    | datetime    | NO   |     | NULL    |       | 日记上传日期
    | diary_gmt_modified  | datetime    | NO   |     | NULL    |       | 日记修改日期
    +---------------------+-------------+------+-----+---------+-------+

/**
  +----------------------------------------------------------------------------+
  |                                 DO 设计                                     |
  +----------------------------------------------------------------------------+
  */

    +-------------------+
    | Tables_in_lifecat |
    +-------------------+
    | admin             |  Admin
    |                   |
    | user              |  User
    | user_property     |  UserProperty
    | user_icon         |  UserIcon
    |                   |
    | image             |  Image
    | image_type        |  Image
    | image_class       |  ImageClass
    | image_feature     |  ImageFeature
    |                   |
    | diary             |  Diary
    +-------------------+

    +-------------------+
    | Admin             | NOT NULL: POJO类型
    +-------------------+
    | admin_id          | 管理员ID，由DAO层返回
    | admin_name        | 管理员用户名，由表单获取
    | admin_password    | 管理员密码，由表单获取
    | admin_level       | 管理员权限，默认
    +-------------------+
    | admin_gmt_create  | 由DAO层负责维护
    | admin_gmt_modified| 由DAO层负责维护
    +-------------------+

    +-------------------+
    | User              | NOT NULL: POJO类型
    +-------------------+
    | user_id           | 用户ID，由DAO层返回
    | user_name         | 用户名，表单获取
    | user_password     | 用户密码，表单获取
    +-------------------+
    | user_gmt_creat    | 由DAO层维护
    | user_gmt_modified | 由DAO层维护
    +-------------------+

    +----------------------+
    | UserProperty         | CAN NULL: 构建者模式
    +----------------------+
    | user_id              | 用户ID，由user对象提供
    | property_nickname    | 昵称 默认
    | property_signature   | 签名 默认
    | property_email       | 邮箱 默认
    | property_Location    | 地址 默认
    | property_birthday    | 生日 默认
    +----------------------+
    | property_gmt_create  | 由DAO层维护
    | property_gmt_modified| 由DAO层维护
    +----------------------+

    +-------------------+
    | UserIcon          | NOT NULL: POJO类型
    +-------------------+
    | user_id           |
    | icon_path         |
    | icon_path         |
    | icon_path         |
    +-------------------+

    +-------------------+    +-------------------+    +-------------------+    +-------------------+
    | Image             |    | ImageType         |    | ImageClas         |    | ImageFeature      |
    +-------------------+    +-------------------+    +-------------------+    +-------------------+
    | image_id          |    | image_id          |    | image_class_id    |    | image_id          |
    | image_text        |    | user_id           |    | image_class_desc  |    | image_class       |
    | image_path        |    | image_class       |    +-------------------+    | image_feature_path|
    | image_gmt_create  |    +-------------------+                             +-------------------+
    | image_gmt_modified|
    +-------------------+

    +-------------------+    +-------------------+
    | Diary             |    | DiaryType         |
    +-------------------+    +-------------------+
    | diary_id          |    | diary_id          |
    | diary_name        |    | user_id           |
    | diary_text        |    +-------------------+
    | image_gmt_create  |
    | image_gmt_modified|
    +-------------------+


/**
  +----------------------------------------------------------------------------+
  |                                 文档说明                                     |
  +----------------------------------------------------------------------------+
  */

类命名规范：
    /**
     * NAME: DESCRIPTION
     *
     * 应用模式
     * 功能概述
     * @auther
     */

方法命名规范:
    /**
     * NAME: DESCRIPTION
     *
     * 1.
     * 2.
     * ...
     *
     * @param
     * @throws
     * @return
     */

/**
  +----------------------------------------------------------------------------+
  |                                Java设计                                     |
  +----------------------------------------------------------------------------+
  */