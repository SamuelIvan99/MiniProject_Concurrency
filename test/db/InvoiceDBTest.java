package db;

import model.Invoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceDBTest {
    private InvoiceIF invoiceDb;
    private DatabaseRecycle databaseRecycle;

    @BeforeEach
    void setUp() {
        invoiceDb = new InvoiceDB();
        databaseRecycle = new DatabaseRecycle();
        databaseRecycle.recycleDatabase();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertInvoice() {
        // arrange
        Invoice invoice = new Invoice("test", "this is a test", "please work");
        boolean created;

        try {
            // act
            created = invoiceDb.insertInvoice(invoice);
            // assert
            assertTrue(created);
            assertEquals(invoice.getDescription(), invoiceDb.findInvoiceByID(3, false).getDescription());
        }
        catch (DataAccessException e){
            fail("Error: Test failed.");
        }
    }

    @Test
    void findInvoiceByID() {
    }

    @Test
    void findInvoiceByTitle() {
    }

    @Test
    void updateInvoice() {
    }

    @Test
    void deleteInvoice() {
    }

    @Test
    void getAllInvoices() {
    }
}