package db;

import model.Invoice;

import java.util.List;

public interface InvoiceIF {

    boolean insertInvoice(Invoice invoice);

    Invoice findInvoiceByTitle(String title, boolean fullAssociation);

    Invoice findInvoiceByID(int id, boolean fullAssociation);

    Invoice updateInvoice(Invoice invoice);

    boolean deleteInvoice(int id);

    List<Invoice> getAllInvoices();
}
