package com.jdk8.toa4.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kobe on 2019/6/15.5:34
 *
 * @author kobe
 * <br/>
 * Description:
 *  Statement 主要用于数据库增删改。
 */
public class StatementDemo {


    public static void main(String[] args) throws Exception {
        String addSql = " insert into test_table values('1','Kobe') ";
        String deleteSql = " delete from test_table where id='1' ";
        String updateSql = " update test_table set name='updateSql' where id=1 ";
        //add(addSql);
        //add(updateSql);
        //add(deleteSql);


        List<String> sqls = new ArrayList<>();
        for (int i = 2; i < 4; i++) {
            if (2 == i) {
                sqls.add(" insert into test_table values('2','Kobe') ");
            } else if (3 == i) {
                sqls.add(" insert into test_table values('3','Kobe') ");
            }
        }
        batch(sqls);
    }


    // 热处理。
    static void batch(List<String> sqls) throws Exception {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        // 准备sql
        for (String sql : sqls) {
            stmt.addBatch(sql);
        }
        // 开始执行。
        stmt.executeBatch();
    }

    static void add(String sql) throws Exception {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        //stmt.execute(sql); // 它返回 boolean
        int i = stmt.executeUpdate(sql); // 它返回int
        // 它们两个都是差不多的，只是返回值不同。
        System.out.println("===: " + i);
    }

}
