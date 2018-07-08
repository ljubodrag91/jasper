package com.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private String username = "SRDEMO";
    private String password = "ORACLE";
	
    private DBConnection() throws SQLException {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }
}
