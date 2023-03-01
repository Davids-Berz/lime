package com.lime.jdbc.Utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/lime";
    private static String username = "root";
    private static String password = "admin";

    private static BasicDataSource dataSource;

    private static Connection connection;

    public static BasicDataSource getInstance() throws SQLException {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setInitialSize(3);
            dataSource.setMinIdle(3);
            dataSource.setMaxIdle(8);
            dataSource.setMaxTotal(8);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
