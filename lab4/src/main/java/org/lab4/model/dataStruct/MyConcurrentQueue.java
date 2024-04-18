package org.lab4.model.dataStruct;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyConcurrentQueue<T> {
    Deque<T> queue;

    public MyConcurrentQueue() {
        queue = new ArrayDeque<>();
    }

    public synchronized void add(T e) {
        queue.add(e);
    }

    public synchronized T removeLast() {
        return queue.removeLast();
    }
}
