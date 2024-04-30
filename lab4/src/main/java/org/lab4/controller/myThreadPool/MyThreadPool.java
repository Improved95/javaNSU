package org.lab4.controller.myThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    private final int threadPoolSize;

    BlockingQueue<RunnableThread> availableThreads;
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();

    AtomicInteger taskQueueSize = new AtomicInteger(0);

    public MyThreadPool(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
        this.availableThreads = new ArrayBlockingQueue<>(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            availableThreads.offer(new RunnableThread(taskQueue, taskQueueSize));
        }

        for (RunnableThread thread : availableThreads) {
            new Thread(thread).start();
        }
    }

    public void addTask(Runnable task) {
        taskQueue.offer(task);
        taskQueueSize.incrementAndGet();
    }

    public void interrupt() {
        for (RunnableThread thread : availableThreads) {
            thread.interrupt();
        }
    }

    public int getTaskQueueSize() {
        return taskQueueSize.get();
    }
}
