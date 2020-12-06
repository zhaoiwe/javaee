package com.jdbcDemo.demomain;

import com.jdbcDemo.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 使用JDBC操作数据库
 * 
 * @author zw
 *
 */
public class CurdDemo {

	// 查询id为1的用户:  抽取: 找不同和相同(1,2,5) 
	@Test
	public void fun01() throws ClassNotFoundException, SQLException {


		
		Connection connection = JdbcUtils.getConnection();
		// 3.创建执行sql语句对象
		Statement statement = connection.createStatement();

		// 4.执行sql语句,处理结果
		String sql = "select *from user where id = 1";

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("username"));
			System.out.println(resultSet.getString("password"));
			System.out.println(resultSet.getString("nickname"));
		}

		// 5.关闭资源(先创建,后关闭)
		JdbcUtils.release(resultSet, statement, connection);

	}

	// 把id为4的用户密码改成666666

	@Test
	public void fun02() throws ClassNotFoundException, SQLException {
		Connection connection = JdbcUtils.getConnection();

		// 3.创建执行sql语句对象
		Statement statement = connection.createStatement();

		// 4.执行sql语句, 如果有结果就处理
		String sql = "UPDATE user SET password = '666666' WHERE id = 4";

		statement.executeUpdate(sql);

		// 5.关闭资源(先创建,后关闭)

	/*	if (statement != null) {
			statement.close();
		}

		if (connection != null) {
			connection.close();
		}*/
		
		JdbcUtils.release(null, statement, connection);

	}

	// 把id为4的用户删除

	@Test
	public void fun03() throws ClassNotFoundException, SQLException {
		Connection connection = JdbcUtils.getConnection();

		// 3.创建执行sql语句对象

		Statement statement = connection.createStatement();

		// 4.执行sql语句
		// 把id为4的用户删除
		String sql = "delete from user where id = 4";
		statement.executeUpdate(sql);

		// 5.关闭资源
		JdbcUtils.release(null, statement, connection);

	}

	// 向user表插入一条数据 INSERT into `user` values(null,'zl','111111','小六子');

	@Test
	public void fun04() throws ClassNotFoundException, SQLException {
		Connection connection = JdbcUtils.getConnection();

		// 3.创建执行sql语句对象

		Statement statement = connection.createStatement();

		// 4.执行sql语句

		String sql = "INSERT into user values(null,'zl','111111','小六子')";

		statement.executeUpdate(sql);

		// 5.关闭资源
		JdbcUtils.release(null, statement, connection);

	}

}
