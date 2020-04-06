package com.company.connectingMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

class QueryDatabase {
    private static DBConnector dbInstance = DBConnector.instantiate();

    private static QueryDatabase instantiation = null;

    private QueryDatabase(){}

    static QueryDatabase instantiate(){
        if(instantiation != null) {
            return instantiation;
        }
        instantiation = new QueryDatabase();
        return instantiation;
    }

    ArrayList get(String query) throws SQLException {
        Connection connection = dbInstance.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSets = statement.executeQuery(query);
        ArrayList result = formatResult(resultSets);
        dbInstance.close(connection);
        return result;
    }

    void insert(String table, String query) throws SQLException {
        Connection connection = dbInstance.connect();
        Statement statement = connection.createStatement();
        String getQuery = String.format("select * from %s order by id desc limit 1", table);
        ResultSet resultSets = statement.executeQuery(getQuery);
        resultSets.next();
        int lastID = resultSets.getInt(1);
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setInt(1, lastID + 1);
        preparedStatement.executeUpdate();
        dbInstance.close(connection);
    }

    void updateAge(String query) throws SQLException {
        Connection connection = dbInstance.connect();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        dbInstance.close(connection);
    }

    void delete(String query) throws SQLException {
        Connection connection = dbInstance.connect();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        dbInstance.close(connection);
    }
    private static ArrayList<HashMap> formatResult(ResultSet resultSet) throws SQLException {
        ArrayList result = new ArrayList<HashMap>();
        while (resultSet.next()) {
            HashMap hash = new HashMap();
            hash.put("id", resultSet.getInt(1));
            hash.put("name", resultSet.getString(2));
            hash.put("age", resultSet.getInt(3));
            result.add(hash);
        }
        return result;
    }
}