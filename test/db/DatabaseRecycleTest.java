package db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import db.DatabaseRecycle;

import javax.xml.crypto.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;


public class DatabaseRecycleTest {

    private DatabaseRecycle recycle;
    private Connection connection;
    private final String SELECT_SQL =
            "SELECT TOP (2) [InvoiceID]" +
                    ",[Title]" +
                    ",[Description]" +
                    ",[Date]" +
                    ",[Solution]" +
                    "FROM [dmai0919_1081509].[dbo].[Invoice]";

    @BeforeEach
    void setUp() {
        recycle = new DatabaseRecycle();
        connection = DatabaseConnection.getConnection();
    }

    @Test
    void cleanDatabaseShouldNotThrow() {
        assertDoesNotThrow(() -> recycle.cleanDatabase());
    }

    @Test
    void restoreDatabaseShouldNotThrow() {
        assertDoesNotThrow(() -> recycle.restoreDatabase());
    }

    @Test
    void recycleDatabaseShouldNotThrow() {
        assertDoesNotThrow(() -> recycle.recycleDatabase());
    }

    @Test
    void cleanDatabaseShouldBeEmpty() {
        try {
            recycle.cleanDatabase();
        } catch (SQLException e) {
            fail(e);
        }
        assertThrows(SQLException.class, () -> {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_SQL);
            stmt.close();
        });
    }


    @Test
    void restoreDatabaseShouldHaveDefaultColumns() {
        try (Statement stmt = connection.createStatement()) {

            recycle.restoreDatabase();
            ResultSet resultSet = stmt.executeQuery(SELECT_SQL);

            assertTrue(resultSet.next());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void recycleDatabaseShouldHaveDefaultColumns() {
        try {
            recycle.recycleDatabase();
            cleanDatabaseShouldBeEmpty();
        } catch (SQLException e) {
            fail(e);
        }
    }

    @AfterEach
    void tearDown() {
        DatabaseConnection.disconnect();
        connection = null;
        recycle = null;
    }
}
