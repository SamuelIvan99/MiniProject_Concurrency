package db;

import model.Invoice;

import java.util.List;

public interface InvoiceIF {

    boolean insertInvoice(Invoice invoice) throws DataAccessException;

    List<Invoice> findInvoiceByTitle(String title, boolean fullAssociation) throws DataAccessException;

    Invoice findInvoiceByID(int id, boolean fullAssociation) throws DataAccessException;

    boolean findEquals (Invoice invoice) throws DataAccessException;

    boolean updateInvoice(Invoice invoice) throws DataAccessException;

    boolean deleteInvoice(int id) throws DataAccessException;

    List<Invoice> getAllInvoices(boolean fullAssociation) throws DataAccessException;
}
