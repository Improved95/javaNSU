package org.lab4.controller.myThreadPool;

import java.util.concurrent.BlockingQueue;

public class RunnableThread implements Runnable {
    private BlockingQueue<Runnable> taskQueue;

    public RunnableThread(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void interrupt() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                taskQueue.take().run();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
