/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: jdbcDemo
 * Author:   zhaowei
 * Date:     2020/12/5 13:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jdbcDemo.demomain;/**
 * Created by zhaowei on 2020/12/5.
 */

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 *  mysqljdbc 连接数据库
 * 〈〉
 *
 * @author zhaowei
 * @create 2020/12/5
 * @since 1.0.0
 */
public class jdbcDemo {


    private String sql;

    public static void main(String[] args) throws SQLException {
         //注册驱动
        DriverManager.registerDriver(new Driver());
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "";
        //获得连接
        Connection connection = DriverManager.getConnection(url, user, password);
         //创建执行sql语句对象
        Statement statement = connection.createStatement();
         //执行sql,处理结果
        String sql = "select *from user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject(2));
            System.out.println(resultSet.getObject(3));
            System.out.println(resultSet.getObject(4));
        }
          //关闭资源
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
