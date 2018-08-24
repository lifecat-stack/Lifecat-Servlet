package com.ten.constant;

/**
 * Host主机配置
 *
 * @auther ten
 */
public class HOST {
    private HOST() {
        throw new AssertionError();
    }

    /**
     * TODO 服务器IP
     */
    public static final String IP = "127.0.0.1";
    /**
     * 项目名称
     */
    private static final String PROJECT = "lifecatweb";
    /**
     * tomcat端口号
     */
    private static final int TOMCAT_PORT = 8080;
    /**
     * 应用上下文目录
     */
    static final String PROJECT_CONTEXT =
            "http://" + IP + ":" + TOMCAT_PORT + "/" + PROJECT + "/";
    /**
     * Host{ip:123,project:asd}
     */
    @Override
    public String toString() {
        return "Host{"
                + "ip:" + IP + ","
                + "project:" + PROJECT
                + "}";
    }
}
