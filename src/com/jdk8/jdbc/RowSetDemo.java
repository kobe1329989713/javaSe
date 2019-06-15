package com.jdk8.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * Created by kobe on 2019/6/15.7:37
 *
 *
 * @author kobe
 * <br/>
 * Description:
 * jdbcRowSet ， 和 jdbc 差不多样。
 */
public class RowSetDemo {
    public static void main(String[] args) throws Exception {

        // 也可以自己实现，它默认使用的是jdk 的默认实现。
        RowSetFactory factory = RowSetProvider.newFactory();
        JdbcRowSet rs = factory.createJdbcRowSet();

        // 连接数据库。
        Class.forName("oracle.jdbc.driver.OracleDriver");
        rs.setUrl("jdbc:oracle:thin:@192.168.92.135:1521:orcl");
        rs.setUsername("scott");
        rs.setPassword("rootkobe");

        // 设置命令，就是 sql 语句。
        // 也可以使用预处理语句。
        // 不要使用* 号。
        rs.setCommand(" select id,name from test_table");
        rs.execute();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + ",  " + rs.getString(2));
        }

        rs.first();
        rs.updateString(2,"rose1");
        rs.updateRow();
    }
}
