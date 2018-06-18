## Form层表单过滤组件层设计 

  * Interface Verifiable 定义检测内容
    * isNull
    * isTooLong
    * isTooShort
    * isDiff
  * Abstract BaseVerification 定义检测骨架类 
  * FormResult 返回结果
    * boolean success
    * String errormsg  