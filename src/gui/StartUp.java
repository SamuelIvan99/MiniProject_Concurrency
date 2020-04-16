package gui;

import controller.RefreshNotifier;

public class StartUp {

    private final static RefreshNotifier refreshNotifier = new RefreshNotifier();

    public static void main(String[] args) {

        Runnable updateCheckerThread = () -> {
            System.out.println("Update checker started");

        };

        Runnable refreshNotifierThread = () -> {
            System.out.println("Starting await refresh");
            refreshNotifier.awaitRefresh();
        };


        InvoiceMenu.start();
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
