package com.wang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @name Connections
 * @description 获取数据库连接 
 * @auther ten
 */
public class Connections implements HOST{
	
	/* jdbc驱动 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("success to load jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    System.out.println("failure to load jdbc.Driver");
			e.printStackTrace();
		}
	}

	/**
	 * @name 连接数据库
	 * @description 获取Conection对象
	 */
	public static Connection getConnection() throws SQLException {
		String url = String.format(
				"jdbc:mysql://%s:%d/%s",
				ip, port, database);
//		System.out.println("try to connect database!");
		Connection c= DriverManager.getConnection(url, loginName, password);
		if(!c.isClosed()){
//			System.out.println("Succeeded connecting to the Database!");
		}else{
			System.out.println("connecting error!");
		}
		return c;
	}

	/**
	 * @name 数据库连接单元测试 java类入口
	 * @description 检测是否能连接到数据库
	 */
	public static void main(String[] args) throws SQLException {
	    Connection c=Connections.getConnection();
	}
}