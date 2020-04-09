package db;

import model.Invoice;

import java.sql.ResultSet;
import java.util.List;

public class InvoiceDB implements InvoiceIF {
    @Override
    public boolean insertInvoice(Invoice invoice) {
        return false;
    }

    @Override
    public Invoice findInvoiceByID(int id, boolean fullAssociation) {
        return null;
    }

    @Override
    public Invoice findInvoiceByTitle(String title, boolean fullAssociation) {
        return null;
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public boolean deleteInvoice(int id) {
        return false;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }

    public Object buildObject(ResultSet resultSet, boolean fullAssociation) {
        return null;
    }

}
