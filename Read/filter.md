## Filter层请求过滤器设计 

  * 字符过滤器 EncodingFilter
  ```text
  将编码转为utf-8
  ```
  * Form表单验证过滤器 FormFilter
  
  |函数|功能|
  |---|---
  |isNull     |空值检测
  |isTooLong  |最大长度检测
  |isTooShort |最短长度检测
  |isDiff     |异同检测
  * 对POST提交的FORM表单进行过滤
  * 返回结果
    * 验证通过 :提交到请求处理层Web层
    * 验证出错 :返回到请求界面，并设置错误提示信息到Session
