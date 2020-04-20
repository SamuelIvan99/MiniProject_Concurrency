package controller;

import db.DataAccessException;
import db.InvoiceDB;
import db.InvoiceIF;
import model.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceController {

    private static InvoiceIF invoiceDB;

    private static List<Invoice> invoiceList;
    private static int currentVersion;

    public InvoiceController() {
        invoiceDB = new InvoiceDB();

        try {
            currentVersion = invoiceDB.getVersionNo();
            invoiceList = invoiceDB.getAllInvoices(true);
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("Couldn't initialize invoices");
        }
    }

    public boolean createInvoice(Invoice invoice) throws DataAccessException {
        if (invoiceDB.findEquals(invoice))
            throw new OperationException("Invoice with these attributes already exists.");

        return invoiceDB.insertInvoice(invoice);
    }

    public Invoice findInvoiceByID(int id, boolean fullAssociation) throws DataAccessException {
        return invoiceDB.findInvoiceByID(id, fullAssociation);
    }

    public List<Invoice> findInvoicesByTitle(String title, boolean fullAssociation) throws DataAccessException {
        return invoiceDB.findInvoiceByTitle(title, fullAssociation);
    }

    public boolean updateInvoice(Invoice invoiceToUpdate, String newTitle, String newDescription, LocalDate newDate, String newSolution, boolean resolved) throws DataAccessException {
        Invoice invoice = new Invoice(newTitle, newDescription, newSolution);
        invoice.setResolved(resolved);

        if (invoiceDB.findInvoiceByID(invoice.getInvoiceID(), false) != null) {
            throw new OperationException("Invoice with these attributes already exists in the database.");
        }

        // simulating long update
        try {
            int x = (int) (Math.random() * 10000);
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!newTitle.isBlank())
            invoiceToUpdate.setTitle(newTitle);
        if (!newDescription.isBlank())
            invoiceToUpdate.setDescription(newDescription);
        if (!newSolution.isBlank())
            invoiceToUpdate.setSolution(newSolution);
        if (newDate != null)
            invoiceToUpdate.setDate(newDate);

        // simulating long update
        try {
            int x = (int) (Math.random() * 10000);
            Thread.sleep(x);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        invoiceToUpdate.setResolved(resolved);
        return invoiceDB.updateInvoice(invoiceToUpdate);
    }

    public boolean deleteInvoice(int id) throws DataAccessException {
        return invoiceDB.deleteInvoice(id);
    }

    public List<Invoice> getAllInvoices(boolean fullAssociation) throws DataAccessException {
        if (isUpToDate(currentVersion)) {
            return new ArrayList<>(invoiceList);
        } else {
            invoiceList = invoiceDB.getAllInvoices(fullAssociation);
            currentVersion = invoiceDB.getVersionNo();
            return new ArrayList<>(invoiceList);
        }
    }

    public void updateVersionNo(int newVersion) throws DataAccessException {
        invoiceDB.updateVersionNo(newVersion);
    }

    public int getVersion() throws DataAccessException {
        return currentVersion;
        //return invoiceDB.getVersionNo();
    }

    public static boolean isUpToDate(int version) throws DataAccessException {
        int versionNo = invoiceDB.getVersionNo();
        boolean upToDate = true;

        if (versionNo == -1) {
            System.out.println("Couldn't connect to the database, using local version.");
        } else if (versionNo != version) {
            upToDate = false;
        }

        return upToDate;
    }

    public static int getCurrentVersion() {
        return currentVersion;
    }
}
