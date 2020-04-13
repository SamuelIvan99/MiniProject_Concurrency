/**
 * @author samuel
 */


package model;

import java.time.LocalDate;

public class Invoice {
    private int invoiceID;
    private String title;
    private String description;
    private LocalDate date;
    private boolean resolved;
    private String solution;

    public Invoice(String title, String description, String solution) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Invoice other = (Invoice) obj;
        return (title == other.title || (title != null && title.equals(other.title)))
                && (description == other.description || (description != null && description.equals(other.description)))
                && (solution == other.solution || (solution != null && solution.equals(other.solution)))
                && (date == other.date || (date != null && date.equals(other.date)));
    }
}
