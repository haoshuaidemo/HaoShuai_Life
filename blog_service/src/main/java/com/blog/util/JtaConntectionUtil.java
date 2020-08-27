package com.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Hao Shuai
 * @Title: JtaConntectionUtil
 * @ProjectName blog_service
 * @Description: jta链接工具类
 * @date 2020/8/418:20
 */
public class JtaConntectionUtil {

    public static Connection getCurrentConnection(){
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

    public static Connection getRemoteConnection(){
        final String url="jdbc:mysql://10.224.65.32:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        final String name="com.mysql.jdbc.Driver";
        final  String user="hahaha";
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
