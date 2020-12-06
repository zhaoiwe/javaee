package com.jdbcDemo.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类(通过配置文件)
 * 
 * @author zw
 *
 */
public class JdbcUtils {
	//硬编码(写死), 配置文件  .properties
	static String driver;
	static String url;
	static String user;
	static String password;
	 

	static {
		// 1.注册驱动(只需要注册一次)
		try {
			//读取一次就行
			//创建propertie对象
			Properties properties = new Properties();
			//根据文件创建输入流
			//InputStream is = new FileInputStream("src\com\jdbcDemo\resources\jdbc.properties");
			//目录已经到了src目录下
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(is);
			
			//获得值
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		
			
			
			Class.forName(driver );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 获得连接
	public static Connection getConnection() throws SQLException {
		
		// 2.获得连接
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;

	}
	
	//关闭资源  
	public static void release(ResultSet resultSet,Statement statement,Connection connection){
		
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
