package test.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import db.DatabaseConnection;

class DatabaseConnectionTest {

    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = DatabaseConnection.connect();
    }

    @Test
    void databaseConnectionShouldNotBeNull() {
        assertNull(connection);
    }

    @AfterEach
    void tearDown() {
        connection = null;
        DatabaseConnection.disconnect();
    }
}