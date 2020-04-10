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
        } catch (DataAccessException e) {
            fail("Error: insert test failed.");
        }
    }

    @Test
    void findInvoiceByID() {
        // arrange
        String expectedTitle = "My roof is not working";

        try {
            // act
            Invoice invoice = invoiceDb.findInvoiceByID(2, false);
            // assert
            assertEquals(expectedTitle, invoice.getTitle());
        } catch (DataAccessException e) {
            fail("Error: find test failed.");
        }
    }

    @Test
    void findInvoiceByTitle() {
    }

    @Test
    void updateInvoice() {
        // arrange
        boolean updated;

        try {
            Invoice invoice = invoiceDb.findInvoiceByID(1, false);
            invoice.setTitle("Update test");
            // act
            updated = invoiceDb.updateInvoice(invoice);
            // assert
            assertEquals(invoice.getTitle(), invoiceDb.findInvoiceByID(1, false).getTitle());
            assertTrue(updated);
        } catch (DataAccessException e){
            fail("Error: update test failed.");
        }
    }

    @Test
    void deleteInvoice() {
        // arrange
        boolean deleted;

        try {
            // act
            deleted = invoiceDb.deleteInvoice(2);
            // assert
            assertTrue(deleted);
            assertNull(invoiceDb.findInvoiceByID(2, false));
        }catch (DataAccessException e){
            fail("Error: delete test failed");
        }
    }

    @Test
    void getAllInvoices() {
        // arrange
        int expectedSize = 2;
        int actualSize = 0;

        try {
            // act
            actualSize = invoiceDb.getAllInvoices(false).size();
            // assert
            assertEquals(expectedSize, actualSize);
        } catch (DataAccessException e) {
            fail("Error: get all invoices test failed");
        }
    }
}