## DAO层数据持久层设计 

  * dao            :dao接口层以及骨架类实现
  * daojdbcimpl    :dao接口jdbc实现层
  * daomybatisimpl :dao接口mybatis实现层
------------------------------------------------------------------------    
    +-------------------+
    | Tables_in_lifecat |  <Interface>
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
------------------------------------------------------------------------
    AdminDAO          
    //注册--插入admin
    int insertAdmin(AdminDO)
    //登录--获取admin
    AdminDO queryAdmin(adminName)
    //注册--判断用户是否存在
    boolean isAdminExisted(adminName)
------------------------------------------------------------------------
    UserDAO
    //登录--获取user              
     queryUser()
    //注册--插入user             
    insertUser(UserDO)
    //注册--用户是否存在            
    isUserExisted()
    //密码更新--更新user          
    updateUserPassword(userPassword)
    //密码更新--查询原密码          
    queryUserPassword()
------------------------------------------------------------------------
    +-------------------+
    | UserPropertyDAO   |
    +-------------------+
    | 资料查询--查询user_property  :   queryUserProperty()
    | 资料更新--更新查询user_property  :insertUserProperty(UserPropertyDO)
    +-------------------+
------------------------------------------------------------------------
    +-------------------+
    | UserIconDAO       |
    +-------------------+
    | 用户头像更新--插入user_icon       insertUserIcon()
    | 资料查询--查询user_icon          queryUserIcon()
    +-------------------+
------------------------------------------------------------------------
    +-------------------+
    | ImageDAO          |
    +-------------------+
    | 图片上传--插入image              insertImage()
    | 图片删除--删除image              deleteImage()
    | 图片文本内容更新--更新image_text   updateImageText()
    | 图片单个查询--查询image          queryImage(image_name/image_id)
    | 图片全部集合查询--查询image       queryImageList(userId)
    | 图片分类集合查询--查询image       queryImageClass(userId,class_id)
    +-------------------+
------------------------------------------------------------------------
    ImageClassDAO
    //TODO
------------------------------------------------------------------------
    ImageFeatureDAO
    //TODO
------------------------------------------------------------------------
    DiaryDAO
    //日记上传--插入diary             
    void insertDiary(DiaryDO)
    //日记更新--更新diary             
    void updateDiary(DiaryDO)
    //日记数据集获取--查询diaryList    
    queryDiaries()
    //日记删除--删除diary             
    deleteDiary()