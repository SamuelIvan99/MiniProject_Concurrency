package controller;

import gui.Updatable;

import javax.management.monitor.Monitor;
import java.util.Scanner;

public class RefreshNotifier {
    private boolean wantsToRefresh = false;
    private Updatable table = null;

    public synchronized void awaitRefresh() {
        try {
            System.out.println("Waiting for update");
            while (!wantsToRefresh) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Another thread signaled refresh, updating the database");
        table.update();
        System.out.println("Table updated");
    }

    public synchronized void signalRefresh(Updatable updatable) {
        System.out.println("Signaling refresh");

//        System.out.println("Do you want to refresh? y/Y: ");

//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        String input = "y";

        if (input.equals("y") || input.equals("Y")) {
            wantsToRefresh = true;
            table = updatable;
            notifyAll();
        } else {
            System.out.println("Update skipped");
        }

    }
}
