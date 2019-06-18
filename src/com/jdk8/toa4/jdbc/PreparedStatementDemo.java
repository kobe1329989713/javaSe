package com.jdk8.toa4.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by kobe on 2019/6/15.6:52
 *
 * @author kobe
 * <br/>
 * Description:
 * PreparendStatement 预处理语句，就是那种带有问号的 sql 语句。
 *  它有一个 Statement 说明它也是一个执行 sql 语句的玩意。
 *
 *  PreparendStatement  它就是一个和 statement 一样的东东，只不过它比 statement 性能更好。
 *  它也能进行增删改查。
 */
@SuppressWarnings("all")
public class PreparedStatementDemo {

    public static void main(String[] args) throws Exception {
        // 因为这个sql 语句它已经被数据库预处理了。你只需要传递具体的数据给它就行，
        // 所以是 ？？
        //String sql = " insert into test_table values (?,?)";
        Connection conn = DBHelper.getConnection();
        //PreparedStatement stmt= conn.prepareStatement(sql);
        // 第一个参数是：它代表第几个 ？ 问号,
        // 第二个参数是：它代表具体的 值。
        //stmt.setInt(1,4);
        //stmt.setString(2,"Preparend");
        // 这些方法就和前面的那些差不多了。
        //stmt.execute();




        // PreparendStatement 预处理的一个查询
        // 注意 查询时，有空格 也会导致查询不出来。尤其是数据库类型为 char 时要注意老。
        String sql2 = " select * from test_table where trim(name)= ? ";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        stmt.setString(1,"Kobe");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }

    }

}
