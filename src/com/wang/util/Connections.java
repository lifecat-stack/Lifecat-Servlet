package com.wang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * jdbc连接mysql
 *
 * @auther ten
 */
public class Connections {

    //不可实例化
    private Connections(){
        throw new AssertionError();
    }

    private static final String URL = String.format(
            "jdbc:mysql://%s:%d/%s",
            HOST.IP, HOST.DATABASEPORT, HOST.DATABASE);

    private static Logger logger = Logger.getLogger("connections");

    /*
     * reflect
     *
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.warning("ClassNotFoundException");
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
        Connection c = DriverManager.getConnection(URL, HOST.LOGIN_NAME, HOST.PASSWORD);
        if (!c.isClosed()) {
            logger.info("Succeeded connecting to the Database!");
        } else {
            throw new NullPointerException("Connection id closed");
        }
        return c;
    }

    /**
     * 加载驱动
     */
    public static void main(String[] args) {
        try {
            Connection c = Connections.getConnection();
        } catch (SQLException e) {
            logger.warning("Connection Error");
            e.printStackTrace();
        }
    }
}