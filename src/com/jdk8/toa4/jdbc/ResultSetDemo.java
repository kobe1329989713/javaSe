package com.jdk8.toa4.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kobe on 2019/6/15.6:11
 *
 * @author kobe
 * <br/>
 * Description:
 * jdbc 查询。
 */
@SuppressWarnings("all")
public class ResultSetDemo {

    public static void main(String[] args) throws Exception {
        String selectSql = " select id,name from test_table ";
        //query(selectSql);
        query2(selectSql);

    }


    // 定位到某行上
    static void query2(String sql) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

// 把 try{} 换成 () 去掉 finally,  用jdk7 的新特性自动关闭连接。
        try {


            connection = DBHelper.getConnection();
            //Statement statement = connection.createStatement();
            // 见名知意。
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery(sql);
            // 定位到某行上
            resultSet.absolute(2);
            //while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            System.out.println("id: " + id + "\t" + "，name: " + name);
            //}
            // 还可以修改数据。
            resultSet.updateString(2,"kobe_Love_??");
            resultSet.updateRow();




        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DBHelper.close(connection,statement,resultSet);

            //if (connection != null) {
            //    try {
            //        connection.close();
            //    } catch (SQLException e) {
            //        e.printStackTrace();
            //    }
            //}
            //if (statement != null) {
            //    try {
            //        statement.close();
            //    } catch (SQLException e) {
            //        e.printStackTrace();
            //    }
            //}
            //if (resultSet != null) {
            //    try {
            //        resultSet.close();
            //    } catch (SQLException e) {
            //        e.printStackTrace();
            //    }
            //}
        }


    }

    static void query(String sql) throws Exception {
        Connection connection = DBHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            // 也可以用别名。和 列名
            // 它可以不用关心列出现在那个位置。
            int id = resultSet.getInt("id");
            // 2 表示的是第几列
            // 它可以不用关心列的名称。注意 这个索引是从 1 开始的。
            String name = resultSet.getString(2);
            System.out.println("id: " + id + "\t" + "，name: " + name);
        }
    }

}
