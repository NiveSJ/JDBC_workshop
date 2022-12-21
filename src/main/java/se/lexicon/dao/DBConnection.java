package se.lexicon.dao;

import se.lexicon.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// todo: change to a proper name
public class DBConnection {

    private static final String DB_USER = "root";
    private static final String DB_PWD = "Nive";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1/world";


    public static Connection getConnection() throws DBConnectionException {

        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBConnectionException("Problem with Database connection,Please Troubleshoot!!");

        }

    }
}
