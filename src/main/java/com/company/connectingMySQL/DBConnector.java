package com.company.connectingMySQL;

import java.sql.*;

class DBConnector {

    static private final String username = "root";
    static private final String password = "admin123";
    static private final String dbName = "learningJava";
    static private final String port = "3306";
    static private final String IP = "localhost";

    private static DBConnector instantiation = null;
    private DBConnector(){}

    static DBConnector instantiate(){
        if (instantiation != null) {
            instantiation = new DBConnector();
        }
        instantiation = new DBConnector();
        return instantiation;
    }

    Connection connect() {
        String connectionString = String.format("jdbc:mysql://%s:%s/%s", IP, port, dbName);
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch(Exception e) { System.out.println(e); }
        return connection;
    }

    void close(Connection connection) throws SQLException {
        connection.close();
    }
}
