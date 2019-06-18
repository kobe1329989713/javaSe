package com.jdk8.toa4.jdbc;

import java.sql.*;

/**
 * Created by kobe on 2019/6/15.5:19
 *
 * @author kobe
 * <br/>
 * Description:
 */
@SuppressWarnings("all")
public class DBHelper {


    public static Connection getConnection() {
        String url = "jdbc:oracle:thin:@192.168.92.135:1521:orcl";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String user = "scott";
        String pass = "rootkobe";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);


            // 得到连接的警告信息。写在这里每次连接时都会得到。
            SQLWarning w = conn.getWarnings();
            while (w != null) {
                int errorCode = w.getErrorCode();
                String sqlState = w.getSQLState();
                String message = w.getMessage();
                System.out.println(errorCode + "\t" + sqlState + "\t" + message);
                w = w.getNextWarning();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getConnection();
    }


}
