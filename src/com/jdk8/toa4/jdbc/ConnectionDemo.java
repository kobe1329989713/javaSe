package com.jdk8.toa4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by kobe on 2019/6/15.4:59
 *
 * @author kobe
 * <br/>
 * Description:
 * 连接 oracle
 *
 * 用于测试数据库的 创建表的语句如下：
 *  CREATE TABLE test_table(id int primary key,name char(20) not null)
 *
 */
public class ConnectionDemo {
    public static void main(String[] args) throws Exception {
        // 1、加载驱动。根据它的路径找到的。
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2、用户名
        String url = "jdbc:oracle:thin:@192.168.92.135:1521:orcl";
        String user = "scott";
        String pass = "rootkobe";
        Connection conn = DriverManager.getConnection(url, user, pass);
        // 3、test
        System.out.println(conn);
// 操作数据库时，你干什么都需要一个连接，所以就把连接数据库那个类，搞成一个工具，
// 直接调用就能获取连接。然后执行你需要的操作。
// 看 DBHelper

        System.out.println(DBHelper.getConnection());

    }
}
