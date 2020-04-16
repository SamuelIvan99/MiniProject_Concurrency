package gui;

import controller.InvoiceController;
import controller.RefreshNotifier;
import db.DataAccessException;

public class StartUp {

    private final static RefreshNotifier refreshNotifier = new RefreshNotifier();
    private static Updatable currentMenu;

    public static void main(String[] args) {

        currentMenu = new InvoiceMenu();

        Runnable updateCheckerThread = () -> {
            System.out.println("Update checker started");

            while (true) {
                try {
                    // Update code
                    if (!InvoiceController.isUpToDate(InvoiceController.getCurrentVersion())) {
                        System.out.println("Detected update. Signaling refresh to the current menu.");
                        refreshNotifier.signalRefresh(currentMenu.getFrame());
                    }


                    // Update every second
                    Thread.sleep(1000);
                } catch (InterruptedException | DataAccessException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable refreshNotifierThread = () -> {
            System.out.println("Starting await refresh");
            refreshNotifier.awaitRefresh();
        };

        currentMenu.start();

        Thread thread1 = new Thread(updateCheckerThread);
        Thread thread2 = new Thread(refreshNotifierThread);

        System.out.println("Starting threads");
        thread1.start();
        thread2.start();

    }

    public static RefreshNotifier getRefreshNotifier() {
        return refreshNotifier;
    }
}
