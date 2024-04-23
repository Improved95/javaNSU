package org.lab4.controller.myThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private final int threadPoolSize;

    BlockingQueue<RunnableThread> availableThreads;
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();

    public MyThreadPool(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
        this.availableThreads = new ArrayBlockingQueue<>(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            availableThreads.offer(new RunnableThread(taskQueue));
        }

        for (RunnableThread thread : availableThreads) {
            new Thread(thread).start();
        }
    }

    public void addTask(Runnable task) {
        taskQueue.offer(task);
    }

    public void interrupt() {
        for (RunnableThread thread : availableThreads) {
            thread.interrupt();
        }
    }

    public int getTaskQueueSize() {
        return taskQueue.size();
    }
}
