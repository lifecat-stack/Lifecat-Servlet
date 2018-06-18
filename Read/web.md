## Web层请求处理层设计 

  * 接收请求
  * 提取URL
  * 从ServiceFoctory获取Service实例
  * 调用Service.execute()
  * 获得返回结果ServcieResult
    * isSuccess==ture  :
      * 根据result.page转发到目标页面
    * isSuccess==false :
      * 返回URL请求界面
      * 设置errormsg到Session