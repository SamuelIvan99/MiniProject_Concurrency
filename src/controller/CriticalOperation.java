package controller;

import gui.Modifiable;

public class CriticalOperation {
    public boolean isBeingModified = false;

    public void update(Modifiable modifiable) throws OperationException {
        if (isBeingModified) {
            throw new OperationException("Please wait for the current operation to finish\n" + "Update "
                    + Thread.currentThread().getId() + " stopped because another is active.");
        }

        isBeingModified = true;
        System.out.println("Update " + Thread.currentThread().getId() + " started");
        try {
            modifiable.modUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        isBeingModified = false;
        System.out.println("Update " + Thread.currentThread().getId() + " finished");
    }

    public void delete(Modifiable modifiable) throws OperationException {
        if (isBeingModified) {
            throw new OperationException("Please wait for the current operation to finish\n" + "Delete "
                    + Thread.currentThread().getId() + " stopped because another is active.");
        }

        isBeingModified = true;
        System.out.println("Delete " + Thread.currentThread().getId() + " started");
        modifiable.modDelete();
        isBeingModified = false;
        System.out.println("Delete " + Thread.currentThread().getId() + " finished");
    }
}
