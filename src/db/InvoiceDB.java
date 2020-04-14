/**
 * @author samuel
 */

package db;

import model.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvoiceDB implements InvoiceIF {
    private final DatabaseConnection instance;

    public InvoiceDB() {
        DatabaseConnection.connect();
        instance = DatabaseConnection.getInstance();
    }

    @Override
    public boolean insertInvoice(Invoice invoice) throws DataAccessException {
        String INSERT_INVOICE = String.format("INSERT INTO Invoice (Title, Description, Solution) "
                        + "VALUES ('%s', '%s', '%s')",
                invoice.getTitle(), invoice.getDescription(), invoice.getSolution());
        int ID = instance.executeInsertWithIdentity(INSERT_INVOICE);
        invoice.setInvoiceID(ID);

        return findInvoiceByID(ID, false) != null;
    }

    @Override
    public Invoice findInvoiceByID(int id, boolean fullAssociation) throws DataAccessException {
        String SELECT_INVOICE = "SELECT * "
                + "FROM Invoice "
                + "WHERE InvoiceID = ?";
        try (PreparedStatement ps = instance.getConnection().prepareStatement(SELECT_INVOICE)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return buildObject(rs, fullAssociation);
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Error while searching for invoice with ID = " + id, ex);
        }
        return null;
    }

    @Override
    public List<Invoice> findInvoiceByTitle(String title, boolean fullAssociation) throws DataAccessException {
        // TODO there is a problem with this find?? Title type and ps.setString are not compatible - possible error
        ArrayList<Invoice> invoices = new ArrayList<>();
        String SELECT_INVOICE = String.format("SELECT * " +
                "FROM Invoice " +
                "WHERE Title = ?");
        try (PreparedStatement ps = instance.getConnection().prepareStatement(SELECT_INVOICE)) {
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                invoices.add(buildObject(rs, fullAssociation));
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Error while searching for an invoice with title = " + title, ex);
        }
        return invoices;
    }

    @Override
    public boolean updateInvoice(Invoice invoice) throws DataAccessException {
        String UPDATE_INVOICE = String.format("UPDATE Invoice "
                        + "SET Title = '%s', Description = '%s', Solution = '%s' "
                        + "WHERE InvoiceID = %d",
                invoice.getTitle(), invoice.getDescription(),
                invoice.getSolution(), invoice.getInvoiceID());

        int rowsChanged = instance.executeUpdate(UPDATE_INVOICE);
        return rowsChanged > 0;
    }

    @Override
    public boolean deleteInvoice(int id) throws DataAccessException {
        String DELETE_INVOICE = String.format("DELETE FROM Invoice "
                + "WHERE InvoiceID = %d", id);
        int rowsChanged;

        try {
            rowsChanged = instance.executeUpdate(DELETE_INVOICE);
        } catch (DataAccessException ex) {
            throw new DataAccessException("Error while trying to delete an invoice with ID = " + id, ex);
        }

        return rowsChanged > 0;
    }

    @Override
    public List<Invoice> getAllInvoices(boolean fullAssociation) throws DataAccessException {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String SELECT_INVOICES = "SELECT * FROM Invoice";

        try {
            ResultSet rs = instance.getConnection().createStatement().executeQuery(SELECT_INVOICES);
            while (rs.next()) {
                invoices.add(buildObject(rs, fullAssociation));
            }
        } catch (SQLException ex) {
            throw new DataAccessException("Error while selecting invoices", ex);
        }
        return invoices;
    }
    
    public void updateVersionNo(int versionNo) throws DataAccessException {
    	String UPDATE_VERSION = String.format("UPDATE TablesVersionNo SET VersionNo = %d WHERE TableName = '%s'", versionNo, "InvoiceTable");
    	try {
    		instance.executeUpdate(UPDATE_VERSION);
    	} catch (DataAccessException e) {
    		 throw new DataAccessException("Error while trying to update version number", e);
		}
    }
    
    public int getVersionNo() throws DataAccessException {
    	String SELECT_VERSION = "SELECT * FROM TablesVersionNo WHERE TableName = 'InvoiceTable'";
    	int versionNo = -1;
    	
    	try {
    		ResultSet rs = instance.getConnection().createStatement().executeQuery(SELECT_VERSION);
    		versionNo = rs.getInt("VersionNo");
    	} catch (SQLException e) {
   		 throw new DataAccessException("Error while trying to get version number", e);
    	}
    	
    	return versionNo;
    }

    public boolean findEquals(Invoice invoice) throws DataAccessException {
        ArrayList<Invoice> invoices = new ArrayList<>(findInvoiceByTitle(invoice.getTitle(), false));
        boolean copyFound = false;

        Iterator<Invoice> it = invoices.iterator();
        while (it.hasNext() && !copyFound) {
            Invoice current = it.next();
            if (current.equals(invoice))
                copyFound = true;
        }

        return copyFound;
    }

    public Invoice buildObject(ResultSet resultSet, boolean fullAssociation) throws DataAccessException {
        try {
            Invoice invoice = new Invoice(
                    resultSet.getString("Title"),
                    resultSet.getString("Description"),
                    resultSet.getString("Solution"));
            invoice.setInvoiceID(resultSet.getInt("InvoiceID"));

            if (fullAssociation) {
            }

            return invoice;
        } catch (SQLException ex) {
            throw new DataAccessException("Could not build invoice object", ex);
        }
    }
}
