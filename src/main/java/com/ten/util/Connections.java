package com.ten.util;

import com.ten.constant.DataBase;
import com.ten.constant.HOST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connections: jdbc连接mysql
 *
 * @auther ten
 */
public class Connections {

    private static Logger logger = LoggerFactory.getLogger(Connections.class);

    private Connections() {
        throw new AssertionError();
    }

    private static final String URL = String.format(
            "jdbc:mysql://%s:%d/%s"+"?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false",
            HOST.IP, DataBase.MYSQL_PORT, DataBase.DATABASE);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * 获取数据库连接
     *
     * @throws SQLException         连接数据库异常
     * @throws NullPointerException 连接关闭
     */
    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(URL, DataBase.MYSQL_NAME, DataBase.MYSQL_PASSWORD);
        if (c.isClosed()) {
            throw new IllegalAccessError("Connection is closed");
        }
        return c;
    }

    /**
     * 加载jdbc驱动
     *
     * @throws SQLException 获取连接失败
     */
    public static void main(String[] args) throws SQLException {
        Connection c = Connections.getConnection();
    }
}