package com.mohamed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL ="jdbc:postgresql://localhost:5432/employee";
    private static final String USER ="postgres";
    private static final String PASSWORD =System.getenv().getOrDefault("DB_PASSWORD", "12345");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL ,USER ,PASSWORD );
    }


}
