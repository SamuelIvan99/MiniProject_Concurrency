package controller;

import javax.management.monitor.Monitor;

public class RefreshNotifier {
    public synchronized void awaitRefresh() throws InterruptedException {
        // TODO
        wait();
    }

    public synchronized void signalRefresh() {
        // TODO
        notifyAll();
    }
}
