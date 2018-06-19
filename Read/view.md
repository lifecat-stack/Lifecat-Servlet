## View层终端显示层设计 

  * __主页index__  
  
  |功能|方式|参数|
  |---|---|---
  |登录Form|POST|userName,userPassword
  |注册Form|POST|rUserName,rUserPassword1,rUserPassword2
  |管理员登录Form|POST|adminName,adminPassword
  |体验Button|GET|userhome.action
  
  * __用户主页userhome__
  
  |功能|方式|参数|
  |---|---|---
  |设置个人信息Form|POST|nickname,signature,sex,email,location,birthday
  |获取个人信息|GET
  |上传头像Form|POST
  |获取头像|GET
  |修改密码Form|POST|oldpassword,newpassword1,newpassword2
  |获取部分日记|GET
  |获取部分图片|GET
  
  * __上传图片upimage__
  
  |功能|方式|
  |---|---
  |上传图片Form|POST
  
  * __上传日记updiary__
  
  |功能|方式|
  |---|---
  |上传日记Form|POST
  
  * __图片展示imageshow__
  
  |功能|方式|
  |---|---
  |获取图片|GET
  |修改图片信息Form|POST
  |删除图片Button|GET
  
  * __图片相册imageshow2__
  
  |功能|方式|
  |---|---
  |获取相册|GET
  |进行分类动作Button|GET
  
  * __日记展示diaryshow__
  
  |功能|方式|
  |---|---
  |获取日记|GET
  |修改日记信息Form|POST
  |删除日记Button|GET
  
  * __错误界面error__
  
  |功能|方式|
  |---|---
  |返回界面Button