package com.blog.mytest;

import com.blog.util.JdbcConnectUtil;

import java.sql.*;

/**
 * @author Hao Shuai
 * @Title: testjdbc
 * @ProjectName blog_service
 * @Description:  jdbc实现事务的操作，成功
 * @date 2020/8/417:05
 */
public class TestJdbc {
    public static void main(String[] args){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        Savepoint savepoint=null;
        try {
            connection= new JdbcConnectUtil().getConnection();
            statement = connection.createStatement();

            String querySql="select * from user";
            String updateSql="update user set username='ddd' where id='1' ";
            String deleteFalseSql="delete * from user where id='2' ";

//          //提交设置不自动
//          connection.setAutoCommit(false);
//          statement.executeUpdate(updateSql);
//          statement.executeQuery(querySql);
//          //俩个操作成功后手动提交
//          connection.commit();

          //回滚
          //自动提交设置不自动
          connection.setAutoCommit(false);
          statement.executeUpdate(updateSql);
          savepoint=connection.setSavepoint();
          statement.executeUpdate(deleteFalseSql);
          //俩个操作成功后手动提交
          connection.commit();

        } catch (SQLException e) {
            try {
                //回滚到回滚点
                connection.rollback(savepoint);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(e.toString());
        }
    }

}
