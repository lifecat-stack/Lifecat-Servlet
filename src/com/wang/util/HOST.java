package com.wang.util;

/**
 * @name HOST
 * @description 主机的配置信息
 * @auther ten
 */
public interface HOST {
    //服务器配置
    String ip = "localhost";
    String project = "lifecatweb";
    //数据库配置
    int tomcatport = 8080;
    int databaseport = 3306;
    String database = "users";
    String encoding = "UTF-8";
    String loginName = "root";
    String password = "wangshihao";
    //应用上下文路径
    String projectcontext = "http://" + ip + ":" + tomcatport + "/" + project + "/";
    //image存储路径--本地路径
    String image_path = "D:\\Java\\lifecatweb\\web\\upimage\\";
    //image存储路径--服务器路径
    String host_image_path = projectcontext + "upimage/";
    //页面服务器路径
    String page_index = projectcontext + "index.jsp";
    String page_userhome = projectcontext + "userhome.jsp";
    String page_upimage = projectcontext + "upimage.jsp";
    String page_imageshow = projectcontext + "imageshow.jsp";
}
