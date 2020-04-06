package com.company.connectingMySQL;

import java.sql.SQLException;

public class DatabaseExceptions extends SQLException {

    public DatabaseExceptions(String error) {
        super(error);
    }
    public DatabaseExceptions() {
        super();
    }

}
