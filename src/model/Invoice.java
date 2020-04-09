package model;

import java.util.Date;

public class Invoice {
    private int invoiceID;
    private String title;
    private String description;
    private Date date;
    private boolean resolved;
    private String solution;

    public Invoice(String title, String description, String solution){
        this.title = title;
        this.description = description;
        this.solution = solution;
        resolved = false;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
