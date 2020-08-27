package com.blog.mytest;

import com.blog.util.JdbcConnectUtil;
import com.blog.util.JtaConntectionUtil;
import org.omg.CORBA.SystemException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.NotSupportedException;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * @author Hao Shuai
 * @Title: TestJTA
 * @ProjectName blog_service
 * @Description: jta分布式事务 -首先确保mysql可以链接到另外一台机器。写两个链接工具类
 * @date 2020/8/418:19
 */
public class TestJTA {
    public static void main(String[] args) throws NotSupportedException, NamingException, javax.transaction.SystemException {
        testJta();
    }

    // 先查是否能链接远程mysql
    // 这里只需要操作远程电脑即可（1.关闭远程电脑防火墙2.创建一个新用户
    // grand all on *.* username@'%' identified by 'password' sith grant option;
    // flush privileges;）
    public static void  testConnectRemote(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection= new JtaConntectionUtil().getRemoteConnection();
            statement = connection.createStatement();
            String querySql="select username from user where id='55'";
            resultSet=statement.executeQuery(querySql);
            resultSet.next();
            System.out.println(resultSet.getString(1));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //进行测试
    //事务和使用某种数据源应该是无关的。应为对数据源不了解。暂且用jdbc连接。
    public static void testJta() throws javax.transaction.SystemException, NotSupportedException, NamingException {
        UserTransaction tx=null;
        Connection connection=null;
        Context context=null;


        //这里看不懂啊，要干啥？
        tx = (javax.transaction.UserTransaction) context.lookup("java:comp/UserTransaction");  //取得JTA事务，本例中是由Jboss容器管理
        javax.sql.DataSource ds = (javax.sql.DataSource) context.lookup("java:/XAOracleDS");  //取得数据库连接池，必须有支持XA的数据库、驱动程序
        tx.begin();
        try {
            DataSource conn = (DataSource) ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserTransaction userTransaction = null;
        Connection connectionA = null;
        Statement statementA = null;

        Connection connectionB = null;
        Statement statementB = null;
        try {
            connectionA = JtaConntectionUtil.getCurrentConnection();
            connectionB = JtaConntectionUtil.getRemoteConnection();

            String updateSql = "update user set username='eee' where id='1' ";
            String deleteFalseSql = "delete * from user where id='2' ";

            //开始事务
            userTransaction.begin();
            statementA = connectionA.createStatement();
            statementB = connectionB.createStatement();
            statementA.executeUpdate(updateSql);
            statementB.executeUpdate(deleteFalseSql);

            //提交
            userTransaction.commit();
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (SystemException | javax.transaction.SystemException systemException) {
                systemException.printStackTrace();
            }
        }
    }


}
