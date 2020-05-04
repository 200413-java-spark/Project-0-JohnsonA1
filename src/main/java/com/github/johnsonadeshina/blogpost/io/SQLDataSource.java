package com.github.johnsonadeshina.blogpost.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataSource {

    private static SQLDataSource instance;
    private String url;
    private String user;
    private String password;

    private SQLDataSource() {
        url = System.getProperty("database.url", "jdbc:mariadb://localhost:3306/blogdb");
        user = System.getProperty("database.username", "root");
        password = System.getProperty("database.password", "root");
    }

    public static SQLDataSource getInstance() {
        if (instance == null) {
            instance = new SQLDataSource();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
