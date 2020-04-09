package db;

import java.sql.*;

/**
 *
 * @author Group-One
 */
public class DatabaseConnection {

    private static final String SERVER_NAME = "hildur.ucn.dk";
    private static final String DB_NAME = "dmai0919_1081509";
    private static final String LOGIN = "dmai0919_1081509";
    private static final String PASSSWORD = "Password1!";

    private static final String CONNECTION_STR = "jdbc:sqlserver://"
            + SERVER_NAME + ":1433;databaseName=" + DB_NAME;

    private static DatabaseConnection instance;
    private static Connection connection;

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STR, LOGIN, PASSSWORD);
        } catch (SQLException ex) {
            System.err.println("Could not connect to " + DB_NAME + " database.");
            System.err.print(ex);
        }
        return connection;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Could not disconnect from " + SERVER_NAME + " server.");
            System.err.print(ex);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}