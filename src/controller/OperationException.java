package controller;

public class OperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String reason;

    public OperationException(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Operation Exception: " + this.reason;
    }
}