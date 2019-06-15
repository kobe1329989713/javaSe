package com.jdk8.jdbc;

import java.sql.*;

/**
 * Created by kobe on 2019/6/15.17:04
 *
 * @author kobe
 * <br/>
 * Description:
 * jdbc 元信息
 * 元信息，描述数据的数据。
 * 数据转移可能就要用到数据库元信息。如；从 oracel 转移到 mysql 中。
 *
 * 如何得到这个
 *  数据库 信息。
 *  在得到这个数据库里 表 的信息。
 *  在得到这个 表 里。列 的信息。
 *
 *  这些都是可以通过 这个元信息来获取到。
 */
public class MetaDataDemo {

    public static void main(String[] args) throws Exception {
        //databaseMetaData();
        resultSetMetaData();
    }

    static void resultSetMetaData() throws Exception {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from test_table");
        ResultSetMetaData data = rs.getMetaData();

        System.out.println(data.getColumnCount());
        System.out.println(data.getColumnName(1));
        System.out.println(data.getColumnClassName(1));
        System.out.println(data.getColumnTypeName(1));
    }

    static void databaseMetaData() throws SQLException {
        Connection conn = DBHelper.getConnection();
        DatabaseMetaData data = conn.getMetaData();

        System.out.println(data.getDatabaseProductName());
        System.out.println(data.getDatabaseProductVersion());
        System.out.println(data.getDriverName());
        System.out.println(data.getDriverVersion());
    }

}
