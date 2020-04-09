package test.db;

import db.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class DatabaseConnectionTest {

    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = DatabaseConnection.connect();
    }

    @Test
    void databaseConnectionShouldNotBeNull() {
        assertNotNull(connection);
    }

    @AfterEach
    void tearDown() {
        connection = null;
        DatabaseConnection.disconnect();
    }
}