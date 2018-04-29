package com.wang.db;
/**
 * @name HOST
 * @description 主机的配置信息
 * @auther ten
 */
public interface HOST {
    /* 数据库配置 */
    String ip = "111.230.244.153";
    int port = 3306;
    String database = "users";
    String encoding = "UTF-8";
    String loginName = "root";
    String password = "wangshihao";

    /* 主机地址设置 */
    String host_index="http://"+ip+":8080/lifecatweb/index.jsp";
    String host_userhome="http://"+ip+":8080/lifecatweb/userhome.jsp";
}
