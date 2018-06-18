## Service层业务逻辑层设计 

   * ServiceFactory 
     * 根据className获取Service接口对象
   * ServiceResult  
     * 1.success :执行是否出错? 
     * 2.errormsg :若出错, 则记录错误信息
     * 3.page :需跳转的界面
   * <Service>接口  
     * ServiceResult execute()
    
   |function|         className|           需操作的表结构|            对应操作请求|               请求类型|
   |---|---|---|---|---
   |管理员登录|       AdminLogin|            admin|                  admin_login.do|            POST
   |管理员注册|       AdminRegister|         admin|                  admin_register.do|         POST
   |用户登录|         UserLogin|             user|                   user_login.do|             POST
   |用户注册|         UserRegister|          user, _property, _icon| user_register.do|          POST
   |用户资料查询|      UserPropertyQuery|     user_property, _icon|   user_property_query.do|    GET
   |用户资料更新|      UserPropertyUpdate|    user_property|          user_property_update.do|   POST
   |用户头像更新|      UserIconUpdate|        user_icon|              user_icon_update.do|       POST
   |用户密码更新|      UserPswUpdate|         user|                   user_password_update.do|   POST
   |图片上传|         ImageUpload|           image|                 image_upload.do|           POST
   |图片删除|         ImageDelete|           image|                  image_delete.do|           GET
   |图片文本内容更新|  ImageTextUpdate|       image|                  image_text_update.do|      POST
   |图片单个查询|      ImageQuery|            image|                  image_query.do|            GET
   |图片全部集合查询|  ImageListQuery|        image|                  image_list_query.do|       GET
   |图片分类集合查询|  ImageClassQuery|       image|                  image_class_query,do|      GET
   |图片分类|         ImageClassify|         image|                  image_classify.do|         GET
   |日记上传|         DiaryUpload|           diary|                  diary_upload.do|           POST
   |日记更新|         DiaryUpdate|           diary|                  diary_update.do|           POST
   |日记数据集获取|    DiaryListQuery|        diary|                  diary_list_query.do|       GET
   |日记删除|         DiaryDelete|           diary|                  diary_delete.do|           GET