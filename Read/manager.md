## Manager层通用处理层设计 

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
------------------------------------------------------------------------
    ---------------------  方法名↓       操作的DAO↓
------------------------------------------------------------------------
    +-------------------+
    | AdminManager      |
    +-------------------+
    | 注册--插入admin  :             insertAdmin(AdminDO)                      --adminDAO

    | 登录--获取admin  :             queryAdmin()                              --adminDAO
    +-------------------+
------------------------------------------------------------------------
    +-------------------+
    | UserManager       |
    +-------------------+
    | 登录--查询user  :               queryUser()                               --UserDAO

    | 注册--插入user  :               insertUser(UserDO)                        --UserDAO
           插入user_property  :       insertUserProperty(UserPropertyDO)        --UserPropertyDAO
           插入user_icon  :           insertUserIcon(UserIconDO)                --UserIconDAO

    | 资料查询--查询user_property  :   queryUserProperty()                        --UserPropertyDAO
               查询user_icon  :       queryUserIcon()                           --UserIconDAO

    | 密码更新--更新user  :            updateUserPassword(userPassword)          --UserDAO

    | 头像更新--更新user_icon  :        updateUserIcon(usericonDO)                --UserIconDAO

    | 资料更新--更新user_property  :    updateUserProperty(UserPropertyDO)        --UserPropertyDAO
    +-------------------+
------------------------------------------------------------------------
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
------------------------------------------------------------------------
    +-------------------+
    | DiaryManager      |
    +-------------------+
    | 日记上传--插入diary  :            insertDiary()                               --DiaryDAO

    | 日记更新--更新diary  :            updateDiary()                               --DiaryDAO

    | 日记数据集获取--查询diary  :       queryDiary()                                --DiaryDAO

    | 日记删除--删除diary  :            deleteDiary()                               --DiaryDAO
    +-------------------+
