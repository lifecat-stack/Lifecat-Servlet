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