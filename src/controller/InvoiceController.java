/**
 * @author samuel
 */

package controller;

import db.DataAccessException;
import db.InvoiceDB;
import db.InvoiceIF;
import model.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceController {

    private InvoiceIF invoiceDB;

    public InvoiceController() {
        invoiceDB = new InvoiceDB();
    }

    public boolean createInvoice(Invoice invoice) throws DataAccessException {
        if(invoiceDB.findEquals(invoice))
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

        if (!newTitle.isBlank())
            invoiceToUpdate.setTitle(newTitle);
        if (!newDescription.isBlank())
            invoiceToUpdate.setDescription(newDescription);
        if (!newSolution.isBlank())
            invoiceToUpdate.setSolution(newSolution);
        if (newDate != null)
            invoiceToUpdate.setDate(newDate);

        invoiceToUpdate.setResolved(resolved);
        return invoiceDB.updateInvoice(invoiceToUpdate);
    }

    public boolean deleteInvoice (int id) throws DataAccessException {
        return invoiceDB.deleteInvoice(id);
    }

    public List<Invoice> getAllInvoices(boolean fullAssociation) throws DataAccessException {
        return new ArrayList<>(invoiceDB.getAllInvoices(fullAssociation));
    }
}
