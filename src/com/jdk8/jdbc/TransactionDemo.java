package com.jdk8.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Created by kobe on 2019/6/15.16:38
 *
 * @author kobe
 * <br/>
 * Description:
 * 事物。
 * 要么全部成功，要么全部失败。
 */
public class TransactionDemo {

    public static void main(String[] args) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            // 关闭事物的自动提交。
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute(" insert into test_table values('9','Tom') ");
            // *****  保存点。可以设置很多保存点，当什么时候，可以回滚到某个保存点去。
            Savepoint sp = conn.setSavepoint();
            //stmt.execute(" insert into test_table values('10',null ) ");
            stmt.execute(" insert into test_table values('10','null' ) ");
            // ***   sp 以前的能执行成功，以后的进行回滚。
            conn.rollback(sp);
            // 提交事物。
            conn.commit();
        } catch (SQLException e) {
            // 出错了，对事物进行回滚。
            conn.rollback();
            e.printStackTrace();
        }

    }

}
