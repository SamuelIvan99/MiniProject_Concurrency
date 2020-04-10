package controller;

import javax.management.monitor.Monitor;

public class RefreshNotifier {
    public synchronized void awaitRefresh() throws InterruptedException {
        wait();
    }

    public synchronized void signalRefresh() {
        notifyAll();
    }
}
