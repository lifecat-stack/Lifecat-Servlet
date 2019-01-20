package com.ten.lifecat.servlet.constant;

/**
 * 数据库配置
 */
public class DataBase {
    private DataBase() {
        throw new AssertionError();
    }

    /**
     * 数据库端口
     */
    public static final int MYSQL_PORT = 3306;
    /**
     * FIXME 数据库
     */
    public static final String DATABASE = "servlet";
    /**
     * 编码格式
     */
    public static final String ENCODING = "UTF-8";
    /**
     * FIXME 数据库用户名
     */
    public static final String MYSQL_NAME = "root";
    /**
     * FIXME 数据库密码
     */
    public static final String MYSQL_PASSWORD = "wangshihao";
}
