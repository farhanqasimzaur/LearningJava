package com.company.connectingMySQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Students {

    public ArrayList getAll() {
        ArrayList resultSet = null;
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            String query = "Select * from students";
            resultSet = queryDatabase.get(query);
//            this.formatResult(resultSet);
        } catch (SQLException e){
            System.out.println(e);
        }
        System.out.println(resultSet);
        return resultSet;
    }

    public void getWith(String name, int age){
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            String query = String.format("Select * from students where name = %s and age = %d", name, age);
            ArrayList resultSet = queryDatabase.get(query);
            this.formatResult(resultSet);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void getWith(String name){
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            String query = String.format("Select * from students where name = %s", name);
            ArrayList resultSet = queryDatabase.get(query);
            this.formatResult(resultSet);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void getWith(int id){
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            String query = String.format("Select * from students where id = %d", id);
            ArrayList resultSet = queryDatabase.get(query);
            this.formatResult(resultSet);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void create(String name, int age) {
        String query = String.format("insert into students(id, name, age) values(?, '%s', %d)", name, age);
        try {

            QueryDatabase queryDatabase = QueryDatabase.instantiate();
           queryDatabase.insert("students", query);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void updateAge(int id, int age) {
        String query = String.format("update students set age = %d where id = %d", age, id);
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            queryDatabase.updateAge(query);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String query = String.format("delete from students where id = %d", id);
        try {
            QueryDatabase queryDatabase = QueryDatabase.instantiate();
            queryDatabase.delete(query);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    private void formatResult (ArrayList result) {
        for (Object hash: result) {
            System.out.println(hash);
        }
    }
}
