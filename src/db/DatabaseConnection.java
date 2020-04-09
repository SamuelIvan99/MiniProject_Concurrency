package db;

import java.sql.*;

/**
 * @author Group-One
 */
public class DatabaseConnection {

    private static final String SERVER_NAME = "hildur.ucn.dk";
    private static final String DB_NAME = "dmai0919_1081509";
    private static final String LOGIN = "dmai0919_1081509";
    private static final String PASSSWORD = "Password1!";

    private static final String CONNECTION_STR = "jdbc:sqlserver://" + SERVER_NAME + ":1433;databaseName=" + DB_NAME;

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

    public int executeUpdate(String sql) throws DataAccessException {
        int res = -1;
        try (Statement s = connection.createStatement()) {
            res = s.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("Could not execute update", e);

        }
        return res;
    }

    /* return the generated key */
    public int executeInsertWithIdentity(String sql) throws DataAccessException {
        ResultSet rs;
        int generatedKey = -1;
        try (Statement s = connection.createStatement()) {
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = s.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Could not execute update", e);
        }
        return generatedKey;
    }

    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void rollbackTransaction() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }

    public static void cleanDB() {
    }

    public static void restoreDB() {
    }
}