package com.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Hao Shuai
 * @Title: JdbcConnectUtil
 * @ProjectName blog_service
 * @Description: jdbc连接数据库的工具类
 * @date 2020/8/417:37
 */
public class JdbcConnectUtil {
    public static void main(String[] args){

    }

    public static Connection getConnection(){
        final String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        final String name="com.mysql.jdbc.Driver";
        final  String user="root";
        final String password="123456";
        Connection connection=null;
        try {
            Class.forName(name);
            connection= DriverManager.getConnection(url,user,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return connection;
    }
}
