package com.wang.util;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Host工具类
 * <p>
 * 单例
 * <p>
 * 描述了服务器配置、数据库配置、路径配置信息
 *
 * @auther ten
 */
public class HOST {

    public static final HOST INSTANCE = new HOST();

    //不可实例化
    private HOST() {
        System.out.println("Host加载:" + this);
    }

    //静态工厂获取单例
    public static HOST getInstance() {
        return INSTANCE;
    }

    //常量域

    //服务器配置
    public static final String IP = "111.230.244.153";
    public static final String PROJECT = "lifecatweb";
    //数据库配置
    public static final int TOMCATPORT = 8080;
    public static final int DATABASEPORT = 3306;
    public static final String DATABASE = "users";
    public static final String ENCODING = "UTF-8";
    public static final String LOGIN_NAME = "root";
    public static final String PASSWORD = "wangshihao";
    //应用上下文路径
    public static final String PROJECTCONTEXT = "http://" + IP + ":" + TOMCATPORT + "/" + PROJECT + "/";
    //image存储路径--本地路径
    public static final String IMAGE_PATH = "/usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/upimage/";
    //分类展示的父目录--本地路径
    public static final String CATEGORY_IMAGE_PATH = "/usr/local/tomcat/apache-tomcat-9.0.6/webapps/lifecatweb/pics/";

    //image存储路径--服务器路径
    public static final String HOST_IMAGE_PATH = PROJECTCONTEXT + "upimage/";
    //分类展示的父目录--服务器路径
    public static final String HOST_CATEGORY_IMAGE_PATH = PROJECTCONTEXT + "pics/";

    //页面服务器路径
    public static final String PAGE_INDEX = PROJECTCONTEXT + "index.jsp";
    public static final String PAGE_USERHOME = PROJECTCONTEXT + "userhome.jsp";
    public static final String PAGE_UPIMAGE = PROJECTCONTEXT + "upimage.jsp";
    public static final String PAGE_IMAGESHOW = PROJECTCONTEXT + "imageshow.jsp";

    //@Host{ip:123,project:asd}
    @Override
    public String toString() {
        return "@Host{"
                + "ip:" + IP + ","
                + "project:" + PROJECT
                + "}";
    }
}
