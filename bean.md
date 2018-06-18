## 数据对象模型设计

------
### DO数据访问对象设计 
* 与数据库表结构一一对应
* 在DAO层中加入控制信息，构建DO对象
* 根据返回DO对象，处理构建DTO对象，发送到外部
* 数据提供者
  * DB  :由数据库返回信息
  * VO  :由request提供信息
  * DAO :由DAO层提供信息
-----------------------------------------
   * AdminDO      
   
   |数据库字段|数据提供层|
   |---|---
   | adminId           | DB
   | adminName         | VO
   | adminPassword     | VO
   | adminLevel        | VO
   | adminGmtCreate    | DAO
   | adminGmtModified  | DAO
    
   * UserDO            
  
   |数据库字段|数据提供层|
   |---|---
   | userId            | DB
   | userName          | VO
   | userPassword      | VO
   | userGmtCreate     | DAO
   | userGmtModified   | DAO
    

   * UserPropertyDO    
   
   |数据库字段|数据提供层|
   |---|---
   | userId            | VO
   | property_nickname | VO
   | property_signature| VO
   | property_email    | VO
   | property_sex      | VO
   | property_Location | VO
   | property_birthday | VO
   | property_gmt_create   |DAO
   | property_gmt_modified |DAO

   * UserIconDO        
   
   |数据库字段|数据提供层|
   |---|---
   | userId            | VO
   | iconPath          | VO
   | iconGmtCreate     | DAO
   | iconGmtModified   | DAO

   * ImageDO           
   
   |数据库字段|数据提供层|
   |---|---
   | imageId          | VO
   | imageText        | VO
   | imagePath        | VO
   | deleted          | DAO
   | userId           | VO
   | imageGmtCreate   | DAO
   | imageGmtModified | DAO

   * ImageClassDO      
   
   |数据库字段|数据提供层|
   |---|---
   | imageClassId      | VO
   | imageClassName    | VO
   | imageClassDesc    | VO
   | classGmtCreate    | DAO
   | classGmtModified  | DAO

   * ImageFeatureDO    
   
   |数据库字段|数据提供层|
   |---|---
   | imageId          | VO
   | imageClass       | VO
   | imageFeaturePath | VO
   | featureGmtCreate |  DAO
   | featureGmtModified |DAO

   * DiaryDO 
             
   |数据库字段|数据提供层|
   |---|---
   | diaryId           | VO
   | diaryName         | VO
   | diary_text        | VO
   | deleted           | DAO
   | userId            | VO
   | diaryGmtCreate    | DAO
   | diaryGmtModified  | DAO

------
### DTO数据传输对象设计 
* Service或Manager向外传输的对象
* 展示层与服务层之间的数据传输对象
* DTO到达显示层后变成VO
* 由DO对象经过DAO转换为DTO对象
* 提供了DO中的用户可访问的数据域
* DTO面向显示层，故采用更直观的命名方式，并非同于DO命名  
* 构建多参数、不定参数、不可变对象：采用构建者模式
* 覆盖了equals() hashCode() toString() comparable()等
------------------------------------------------------------------------
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
    | userId            |
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
    | imageClassId      |
    +-------------------+

    +-------------------+
    | DiariyDTO         | 用户日记
    +-------------------+
    | diaryid           |
    | diaryname         |
    | diarytext         |
    | diarydate         |
    +-------------------+
------------------------------------------------------------------------
  * 不可变对象↑单个实体    
  * 可变对象↓实体集合
------------------------------------------------------------------------
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
