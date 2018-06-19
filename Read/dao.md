## DAO层数据持久层设计 

  * dao            :dao接口层以及骨架类实现
  * daojdbcimpl    :dao接口jdbc实现层
  * daomybatisimpl :dao接口mybatis实现层
------------------------------------------------------------------------    
   
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

------------------------------------------------------------------------
   * AdminDAO          
     * 注册--插入admin  
       * void insertAdmin(AdminDO adminDO) throws SQLException;
     * 登录--获取admin  
       * AdminDO queryAdmin(String adminName) throws SQLException;
     * 注册--判断用户是否存在  
       * boolean isAdminExisted(String adminName) throws SQLException;
   * UserDAO
     * 登录--获取user              
       * UserDO queryUser(String userName) throws SQLException;
     * 注册--插入user             
       * int insertUser(UserDO userDO) throws SQLException;
     * 注册--用户是否存在            
       * boolean isUserExisted(String userName) throws SQLException;
     * 密码更新--更新user          
       * void updateUserPassword(Integer userId,String password) throws SQLException;
     * 密码更新--查询原密码          
       * String queryUserPassword(String userName) throws SQLException;
  * UserPropertyDAO   
     * 资料查询--查询user_property   
       * UserPropertyDO queryUserProperty(Integer userId) throws SQLException;
     * 资料更新--更新查询user_property  
       * void insertUserProperty(UserPropertyDO userPropertyDO) throws SQLException;
  * UserIconDAO       
     * 用户头像更新--插入user_icon       
       * void insertUserIcon(UserIconDO userIconDO) throws SQLException;
     * 资料查询--查询user_icon          
       * String queryUserIcon(Integer userId) throws SQLException;
     * 资料更新--更新icon_path
       * void updateUserIcon(UserIconDO userIconDO) throws SQLException;
  * ImageDAO          
     * 图片上传--插入image              
       * int insertImage(ImageDO imageDO) throws SQLException;
     * 图片删除--删除image              
       * void deleteImage(int imageId) throws SQLException;
     * 图片文本内容更新--更新image_text   
       * void updateImageText(int imageId, String newText) throws SQLException;
     * 图片单个查询--查询image          
       * ImageDO queryImage(int imageId) throws SQLException;
     * 图片全部集合查询--查询image       
       * List<ImageDO> queryImageList(int userId) throws SQLException;
     * 图片分类集合查询--查询image       
       * List<ImageDO> queryImageClass(int userId, int classId) throws SQLException;
  * ImageClassDAO
     * //TODO
    ImageFeatureDAO
     * //TODO
  * DiaryDAO
     * 日记上传--插入diary             
       * int insertDiary(DiaryDO diaryDO) throws SQLException;
     * 日记更新--更新diary             
       * void updateDiary(DiaryDO diaryDO) throws SQLException;
     * 日记数据集获取--查询diaryList  
       * DiaryDO queryDiary(String diaryName) throws SQLException;
       * List<DiaryDO> queryDiaryList(Integer userId) throws SQLException;
     * 日记删除--删除diary             
       * void deleteDiary(Integer diaryId) throws SQLException;
