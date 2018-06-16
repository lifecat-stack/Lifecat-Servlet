package com.wang.constant;

/**
 * 数据库配置
 *
 * @date 2018/5/24
 * @auther ten
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
     * 数据库
     */
    public static final String DATABASE = "lifecat";
    /**
     * 编码格式
     */
    public static final String ENCODING = "UTF-8";
    /**
     * 数据库用户名
     */
    public static final String MYSQL_NAME = "root";
    /**
     * 数据库密码
     */
    public static final String MYSQL_PASSWORD = "wangshihao";
}
