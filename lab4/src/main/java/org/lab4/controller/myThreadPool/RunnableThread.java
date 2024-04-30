package org.lab4.controller.myThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableThread implements Runnable {
    private BlockingQueue<Runnable> taskQueue;
    private AtomicInteger taskQueueSize;

    public RunnableThread(BlockingQueue<Runnable> taskQueue, AtomicInteger taskQueueSize) {
        this.taskQueue = taskQueue;
        this.taskQueueSize = taskQueueSize;
    }

    public void interrupt() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                taskQueue.take().run();
                taskQueueSize.decrementAndGet();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
