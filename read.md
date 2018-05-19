README
===========================

|title|content|
|---|---
|desc|智能成长相册网站lifecat
|author|ten
|version|Version 2
|date|2018-05
|brief|基于MVC的Javaweb网站开发

  ******************************************************************************

  _@访问链接_  
  * 官网主页 :http://www.lifecat.club  
  * 相册主页 :http://111.230.244.153:8080/lifecatweb

  ******************************************************************************

  _@使用技术_
  * 前端 :Html CSS JavaScript
  * 前端框架 :bootstrap jQuery
  * 后端 :jsp servlet jdbc
  * 后端框架 :MVC-Model2 sturts设计理念
  * 设计模式 :构建者模式 静态工厂模式 单例模式
  * 单元测试 :Junit4
  * 数据库 :MySql-mariadb

  ******************************************************************************
  
  _@Web目录_
  * web
    * include
      * home
        * homePage.jsp   //用户主页body内容部件
      * footer.jsp       //页脚部件
      * header.jsp       //页眉部件
      * -top.jsp          //页面标题栏部件
    * WEB-INF
      * imageshow.jsp    //用户图片展示界面
      * imageshow2.jsp   //用户分类图片展示界面
      * updiary.jsp      //上传日记
      * upimage.jsp      //上传图片
      * userhome.jsp     //用户主页
    * index.jsp          //登录/注册界面
      
  ******************************************************************************
  
  _@Java目录_

  * src
    * main
        * openfunc      //开放接口层 :接收Android端HTTP请求, 并返回请求结果
        * doo           //DO包 :对应于数据库表结构, POJO类型
        * dto           //DTO包 :数据传输对象, 对应逻辑实体，采用构建者模式 或 工厂模式
        * dao           //DAO层 :执行jdbc数据库交互, DAO层通过静态工厂获取
        * manager       //Manager层 :DAO层的抽象逻辑操作, Manager层通过静态工厂获取
        * filter        //Filter过滤器 :对所有请求执行Encoding过滤, 对*.do请求执行Form表单过滤
        * form          //Form表单验证 :对相应表单执行过滤, 确保格式编码等, 返回Result
        * exfunc        //外部接口 :通过java call shell方式, 调用本地python脚本, 执行机器学习操作
        * controller    //Web层 :通过请求内容, 调用相应Service, 转发到Service并获取返回结果
        * service       //Service层 :执行具体业务逻辑, 并且通过try-catch处理底层抛出异常, 传输DTO到表现层
        * util          //工具类 :包括时间类, 连接类, 图片写入操作, 主机配置等
    * test
        * Test          //单元测试
 
  *******************************************************************************
  
  _@应用分层_  
      ○上层依赖于下层                               
      ○箭头关系表示可直接依赖     
   *                         
                                                    ○1.开放接口层: (openfunc包)
                                                        可直接封装Service方法暴露成RPC接口;
                                                        通过web封装成HTTP接口, 可进行远程调用
          +---------+   +-----------------+
          |终端显示层|   |     开放接口     |        ○1.终端显示层: (web包)
          +---------+   +-----------------+              MVC-表现层: 模板渲染层, 主要是JSP渲染
                                 |    ^
          +------------------+   |    |             ○2.Web层: (controller包-ActionServlet)
          |请求处理层(web层)  |   |    |                 MVC-控制器层: 负责转发请求
          +------------------+   |    |                 对访问控制进行转发, 对各类基本参数校验
                                 v    |
          +------------------------------+          ○3.Service层: (service包-<Service>)
          |     业务逻辑层(Service层)     |              MVC-模型层: 处理抽象业务逻辑， 具体的业务逻辑服务层
          +------------------------------+              对request对象进行处理, 转化为DO对象
            |  ^
            |  |  +----------------------+          ○4.Manager层: (manager包-<Manager>)
            |  |  | 通用处理层(Manager层) |              DAO逻辑层, 接收DO对象, 调用DAO层对DO执行具体操作
            |  |  +----------------------+              对service层的下沉处理: 抽象业务逻辑->抽象DAO逻辑
            v  |               |    ^
          +----------------+   |    |               ○5.DAO层: (dao包-<DAO>)
          |数据持久层(DAO层)|   |    |                   对Manager层的下沉处理: 抽象DAO逻辑->具体DAO操作
          +----------------+   |    |                   数据访问层, 执行具体jdbc操作, 进行数据库交互
                               v    |
          +-------+   +---------------------+       ○6.外部接口层: (exfunc包)
          | 数据源 |   | 外部接口或第三方平台 |            调用外部python接口, 实现机器学习的操作
          +-------+   +---------------------+
                                                    ○以上调用的返回类型 Result接口
  *       ○分层异常处理:
  *           DAO层: 抛出细粒度异常
  *           Manager层: 使用catch(Exception e)捕获所有异常, 并throw new DAOException(e), 不需打印日志
  *           Service层: 捕获异常, 记录日志, 不可再向上抛出, 并进行错误页面处理
  *
  ******************************************************************************
  * @请求流程分析
  *
  *  用户请求
  *   |          根据result对象, 转发到对应视图, 视图层通过访问DTO对象
  *   |    +----------------------------------------------------------------+
  *   |    |                                                                |
  *   V    v                                      Form表单验证          控制器: 转发请求
  *  +------+                                         |                 +----------+
  *  | view |                                         v                 |controller|
  *  +------+  'action.do'      映射      web.xml    过滤器     DTO       +----------+
  *  web视图层 ----------- > url-pattern --------- > filter --------- > ActionServlet <---+
  *    jsp                                                                  |            |
  *                                                                         | 根据.do     | 返回结果
  *                                               返回数据库处理结果DTO        | 转发请求     | ModelResult
  *                                            +-------------------+        | 调用Service | 执行转发
  *                                            |                   |        |            |
  *             jdbc                           |        表单数据     v        v            |
  *     DB < ----------- DAO < -----------  Manager  <-------------  Service ------------+
  *     数据库   DO     数据库访问层        处理DAO层抽象逻辑            +---------+
  *     |                 |                    ^                   |  model  | ----------> 将结果对象DTO
  *     |                 |                    |                   +---------+             设置到Session
  *     |                 +--------------------+              模型层: 处理具体业务逻辑
  *     v                       返回DTO对象                          处理接收到的DTO对象
  *  DO对应数据表
  *
  ******************************************************************************
  */
/**
  +----------------------------------------------------------------------------+
  |                                文档说明                                     |
  +----------------------------------------------------------------------------+
  */

  =>《Java开发手册》标记说明
  √ :项目中使用并遵循
  × :未使用规范
  ? :项目未使用或存疑
  ! :重要
  ps:补充



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
    | property_sex        | varchar(10) | YES  |     | NULL    |       | 用户性别
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
    | is_deleted          | unsigned tinyint NO|     | NULL    |       | 日记是否删除
    | idx_is_deleted      | unsigned tinyint NO| IDX | NULL    |       | 索引: 日记是否删除
    | user_id             | unsigned int| NO   |     | NULL    |       | 所属user_id
    | idx_user_id         | unsigned int| NO   | IDX | NULL    |       | 索引: user_id
    | diary_gmt_create    | datetime    | NO   |     | NULL    |       | 日记上传日期
    | diary_gmt_modified  | datetime    | NO   |     | NULL    |       | 日记修改日期
    +---------------------+-------------+------+-----+---------+-------+

/**
  +----------------------------------------------------------------------------+
  |                                DTO 数据传输对象 设计                          |
  +----------------------------------------------------------------------------+
  */

    ○Service或Manager向外传输的对象
    ○展示层与服务层之间的数据传输对象
    ○DTO到达显示层后变成VO
    ○由DO对象经过DAO转换为DTO对象
    ○提供了DO中的用户可访问的数据域

    ○DTO面向显示层，故采用更直观的命名方式，并非同于DO命名
    =>采用驼峰命名法
    ○构建多参数、不定参数、不可变对象：采用构建者模式
    ○覆盖了equals() hashCode() toString() comparable()等

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

    ---------------------

    +-------------------+
    | AdminDTO          | 管理员
    +-------------------+
    | adminid           |
    | adminname         |
    | adminlevel        |
    +-------------------+

    +-------------------+
    | UserDTO           | 用户
    +-------------------+
    | userid            |
    | username          |
    +-------------------+

    +-------------------+
    | UserPropertyDTO   | 用户资料
    +-------------------+
    | user_id           |
    | nickname          |
    | signature         |
    | email             |
    | sex               |
    | location          |
    | birthday          |
    | iconpath          |
    +-------------------+

    +-------------------+
    | ImageDTO          | 图片信息
    +-------------------+
    | imageid           |
    | imagetext         |
    | imagepath         |
    | imagedate         |
    | imagetype         |
    +-------------------+

    +-------------------+
    | DiariyDTO         | 用户日记
    +-------------------+
    | diaryid           |
    | diaryname         |
    | diarytext         |
    | diarydate         |
    +-------------------+

    不可变对象↑     单个实体
    ---------------------
    可变对象↓       实体集合

    +-------------------+
    | AlbumDTO          | 用户相册-全部
    +-------------------+
    | userid            |
    | List<Image>       |
    +-------------------+

    +-------------------+
    | AlbumClassDTO     | 用户相册-分类
    +-------------------+
    | userid            |
    | List<Image>       |
    | albumclass        |
    +-------------------+

    +-------------------+
    | DiariesDTO        | 用户日记集合
    +-------------------+
    | userid            |
    | List<Diary>       |
    +-------------------+

/**
  +----------------------------------------------------------------------------+
  |                              DO 数据对象 设计                                |
  +----------------------------------------------------------------------------+
  */

    ○与数据库表结构一一对应，通过DAO层向上传输数据源对象
    ○获取request对象信息，在DAO层中加入控制信息，构建DO对象
    ○根据返回DO对象，处理构建DTO对象，发送到外部

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
                                     DB  :由数据库返回信息
    --------------------- 数据提供者↓ VO  :由模型层提供信息
                                     DAO :由DAO层提供信息

    +-------------------+
    | AdminDO           |
    +-------------------+
    | admin_id          | DB
    | admin_name        | VO
    | admin_password    | VO
    | admin_level       | VO
    | admin_gmt_create  | DAO
    | admin_gmt_modified| DAO
    +-------------------+

    +-------------------+
    | UserDO            |
    +-------------------+
    | user_id           | DB
    | user_name         | VO
    | user_password     | VO
    | user_gmt_create   | DAO
    | user_gmt_modified | DAO
    +-------------------+

    +-------------------+
    | UserPropertyDO    |
    +-------------------+
    | user_id           | VO
    | property_nickname | VO
    | property_signature| VO
    | property_email    | VO
    | property_sex      | VO
    | property_Location | VO
    | property_birthday | VO
    | property_gmt_create   DAO
    | property_gmt_modified DAO
    +-------------------+

    +-------------------+
    | UserIconDO        |
    +-------------------+
    | user_id           | VO
    | icon_path         | VO
    | icon_gmt_create   | DAO
    | icon_gmt_modified | DAO
    +-------------------+

    +-------------------+
    | ImageDO           |
    +-------------------+
    | image_id          | VO
    | image_text        | VO
    | image_path        | VO
    | is_deleted        | DAO
    | user_id           | VO
    | image_gmt_create  | DAO
    | image_gmt_modified| DAO
    +-------------------+

    +-------------------+
    | ImageTypeDO       |
    +-------------------+
    | image_id          | VO
    | user_id           | VO
    | image_class       | VO
    | type_gmt_create   | DAO
    | type_gmt_modified | DAO
    +-------------------+

    +-------------------+
    | ImageClassDO      |
    +-------------------+
    | image_class_id    | VO
    | image_class_name  | VO
    | image_class_desc  | VO
    | class_gmt_create  | DAO
    | class_gmt_modified| DAO
    +-------------------+

    +-------------------+
    | ImageFeatureDO    |
    +-------------------+
    | image_id          | VO
    | image_class       | VO
    | image_feature_path| VO
    | feature_gmt_create|  DAO
    | feature_gmt_modified DAO
    +-------------------+

    +-------------------+
    | DiaryDO           |
    +-------------------+
    | diary_id          | VO
    | diary_name        | VO
    | diary_text        | VO
    | is_deleted        | DAO
    | user_id           | VO
    | diary_gmt_create  | DAO
    | diary_gmt_modified| DAO
    +-------------------+

/**
  +----------------------------------------------------------------------------+
  |                              Service 逻辑处理 设计                           |
  +----------------------------------------------------------------------------+
  */

    ○ServiceFactory :根据className获取Service接口对象
    ○ServiceResult  :1.error :执行是否出错? 2.errormsg :若出错, 则记录错误信息 3.page :需跳转的界面
    ○<Service>接口  :ServiceResult execute()方法

    function         className            需操作的表结构           对应操作请求               请求类型

    ○管理员登录       AdminLogin            admin                 admin_login.do           POST
    ○管理员注册       AdminRegister         admin                 admin_register.do        POST

    ○用户登录         UserLogin            user                   user_login.do            POST
    ○用户注册         UserRegister         user, _property, _icon user_register.do         POST
    ○用户资料查询      UserPropertyQuery    user_property, _icon   user_property_query.do   GET
    ○用户资料更新      UserPropertyUpdate   user_property          user_property_update.do  POST
    ○用户头像更新      UserIconUpdate       user_icon              user_icon_update.do      POST
    ○用户密码更新      UserPswUpdate        user                   user_password_update.do  POST

    ○图片上传         ImageUpload          image, image_type      image_upload.do          POST
    ○图片删除         ImageDelete          image                  image_delete.do          GET
    ○图片文本内容更新   ImageTextUpdate      image                  image_text_update.do     POST
    ○图片单个查询      ImageQuery           image                  image_query.do           GET
    ○图片全部集合查询   ImageListQuery       image                  image_list_query.do      GET
    ○图片分类集合查询   ImageClassQuery      image_type, image      image_class_query,do     GET
    ○图片分类         ImageClassify        image_type              image_classify.do       GET

    ○日记上传         DiaryUpload          diary                  diary_upload.do          POST
    ○日记更新         DiaryUpdate          diary                  diary_update.do          POST
    ○日记数据集获取    DiaryListQuery       diary                  diary_list_query.do      GET
    ○日记删除         DiaryDelete          diary                  diary_delete.do          GET

/**
  +----------------------------------------------------------------------------+
  |                              Manager 数据库抽象逻辑对象 设计                   |
  +----------------------------------------------------------------------------+
  */

    ○

    +-------------------+
    | Manager           |
    +-------------------+
    | AdminManager      | 管理员模块
    |                   |
    | UserManager       | 用户模块
    |                   |
    | ImageManager      | 图片模块
    |                   |
    | DiaryManager      | 日记模块
    +-------------------+

    ---------------------  方法名↓       操作的DAO↓

    +-------------------+
    | AdminManager      |
    +-------------------+
    | 注册--插入admin  :             insertAdmin(AdminDO)                      --adminDAO

    | 登录--获取admin  :             queryAdmin()                              --adminDAO
    +-------------------+

    +-------------------+
    | UserManager       |
    +-------------------+
    | 登录--查询user  :               queryUser()                               --UserDAO

    | 注册--插入user  :               insertUser(UserDO)                        --UserDAO
           插入user_property  :       insertUserProperty(UserPropertyDO)        --UserPropertyDAO
           插入user_icon  :           insertUserIcon(UserIconDO)                --UserIconDAO

    | 资料查询--查询user_property  :   queryUserProperty()                        --UserPropertyDAO
               查询user_icon  :       queryUserIcon()                           --UserIconDAO

    | 密码更新--更新user  :            updateUserPassword(user_password)          --UserDAO

    | 头像更新--更新user_icon  :        updateUserIcon(usericonDO)                --UserIconDAO

    | 资料更新--更新user_property  :    updateUserProperty(UserPropertyDO)        --UserPropertyDAO
    +-------------------+

    +-------------------+
    | ImageManager      |
    +-------------------+
    | 图片上传--插入image  :           insertImage()                              --ImageDAO
               插入image_type表  :    insertImageType()                          --ImageTypeDAO

    | 图片删除--从image表删除  :        deleteImage()                              --ImageDAO

    | 图片文本内容更新--更新image  :     updateImage()                              --ImageDAO

    | 图片单个查询--查询image  :         queryImage()                               --ImageDAO

    | 图片全部集合查询--查询image  :     queryImageList()                            --ImageDAO

    | 图片分类集合查询--查询image,image_type  :queryImageClass()                     --ImageDAO,ImageTypeDAO

    | 图片分类--调用外部接口
    +-------------------+


    +-------------------+
    | DiaryManager      |
    +-------------------+
    | 日记上传--插入diary  :            insertDiary()                               --DiaryDAO

    | 日记更新--更新diary  :            updateDiary()                               --DiaryDAO

    | 日记数据集获取--查询diary  :       queryDiary()                                --DiaryDAO

    | 日记删除--删除diary  :            deleteDiary()                               --DiaryDAO
    +-------------------+

/**
  +----------------------------------------------------------------------------+
  |                              DAO 数据库访问对象 设计                           |
  +----------------------------------------------------------------------------+
  */

    dao     :dao接口层
    daoimpl :dao实现类

=>《Java开发手册》5.3 SQL语句:
    √ 1 :使用count(*)--SQL标准, 与数据库无关; 若使用count(列名)或count(常量), 不会统计NULL行

    ? 2 :count(distinct col)计算该列除NULL外的不重复列数, 若出现NULL, 则不统计

    ? 3 :当一列的值全为NULL, count(col)返回结果为0, sum(col)返回结果为NULL

    √ 4 :ISNULL()判断是否为NULL

    √ ps:NULL值与任何值的直接比较都为NULL
         NULL<>NULL :
         NULL-NULL  : 返回结果为NULL, 而不是true/false
         NULL<>1    :

    ? 5 :在代码中写分页查询逻辑时, 若count为0应直接返回, 避免执行后面的分页语句

    √!6 :不得使用外键与级联, 一切外键概念必须在应用层解决

    ? ps:如果更新user_id, 同时触发user_property中的user_id更新, 即为级联更新
         外键与级联更新适用于单机低并发, 不适合分布式, 高并发集群
         级联更新是强阻塞, 存在数据库更新风暴的风险, 外键影响数据插入速度





    ○DAO接口, 通过DAOFactory获取

    +-------------------+
    | Tables_in_lifecat |
    +-------------------+
    | admin             |  AdminDAO
    |                   |
    | user              |  UserDAO
    | user_property     |  UserPropertyDAO
    | user_icon         |  UserIconDAO
    |                   |
    | image             |  ImageDAO
    | image_type        |  ImageTypeDAO
    | image_class       |  ImageClassDAO
    | image_feature     |  ImageFeatureDAO
    |                   |
    | diary             |  DiaryDAO
    +-------------------+

    +-------------------+
    | AdminDAO          |
    +-------------------+
    | 注册--插入admin :insertAdmin()    --参数 :AdminDO    --返回 :主键admin_id
    | 登录--获取admin :queryAdmin()    --参数 :admin_name    --返回 :AdminDO
    | 注册--判断用户是否存在  :isAdminExisted()    --参数 :admin_name    --返回 :boolean
    +-------------------+

    +-------------------+
    | UserDAO           |
    +-------------------+
    | 登录--获取user  :               queryUser()
    | 注册--插入user  :               insertUser(UserDO)
    | 密码更新--更新user  :            updateUserPassword(user_password)
    +-------------------+

    +-------------------+
    | UserPropertyDAO   |
    +-------------------+
    | 资料查询--查询user_property  :   queryUserProperty()
    | 资料更新--更新查询user_property  :updateUserProperty(UserPropertyDO)
    +-------------------+

    +-------------------+
    | UserIconDAO       |
    +-------------------+
    | 用户头像更新--插入user_icon       insertUserIcon()
    | 资料查询--查询user_icon          queryUserIcon()
    +-------------------+

    +-------------------+
    | ImageDAO          |
    +-------------------+
    | 图片上传--插入image              insertImage()
    | 图片删除--删除image              deleteImage()
    | 图片文本内容更新--更新image_text   updateImageText()
    | 图片单个查询--查询image          queryImage(image_name/image_id)
    | 图片全部集合查询--查询image       queryImageList(user_id)
    | 图片分类集合查询--查询image       queryImageClass(user_id,class_id)
    +-------------------+

    +-------------------+
    | ImageTypeDAO      |
    +-------------------+
    | 图片上传--插入图片类别信息        insertImageType()
    | 图片分类集合查询--查询某类别下的image   queryImageByClass(user_id,class_id)
    +-------------------+

    +-------------------+
    | ImageClassDAO     |
    +-------------------+
    +-------------------+

    +-------------------+
    | ImageFeatureDAO   |
    +-------------------+
    +-------------------+

    +-------------------+
    | DiaryDAO          |
    +-------------------+
    | 日记上传--插入diary             insertDiary()
    | 日记更新--更新diary             updateDiary()
    | 日记数据集获取--查询diaryList    queryDiaries()
    | 日记删除--删除diary             deleteDiary()
    +-------------------+

/**
  +----------------------------------------------------------------------------+
  |                              DO 数据库访问对象 设计                           |
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

/**
  +----------------------------------------------------------------------------+
  |                                Java设计 异常日志                             |
  +----------------------------------------------------------------------------+
  */

