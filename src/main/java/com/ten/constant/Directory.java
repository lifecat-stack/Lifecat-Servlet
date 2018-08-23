package com.ten.constant;

/**
 * 服务器文件目录
 *
 * @date 2018/5/24
 * @auther ten
 */
public class Directory {
    private Directory() {
        throw new AssertionError();
    }

    /**
     * 默认显示image存储路径--服务器路径
     */
    public static final String DEFAULT_IMAGE_PATH = "http://localhost:8080/lifecatweb/images/usericon.jpg";

    /**
     * image存储路径--本地路径
     */
    public static final String IMAGE_PATH = "/usr/local/tomcat/webapp/lifecatweb/src/main/webapp/image/";
    /**
     * 分类展示的父目录--本地路径
     */
    public static final String CATEGORY_IMAGE_PATH = "/usr/local/tomcat/webapp/lifecatweb/src/main/webapp/pics/";
    /**
     * image存储路径--服务器路径
     */
    public static final String HOST_IMAGE_PATH = HOST.PROJECT_CONTEXT + "image/";
    /**
     * 分类展示的父目录--服务器路径
     */
    public static final String HOST_CATEGORY_IMAGE_PATH = HOST.PROJECT_CONTEXT + "pics/";
}
