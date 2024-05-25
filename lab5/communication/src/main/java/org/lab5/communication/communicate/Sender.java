package org.lab5.communication.communicate;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sender implements Runnable {
    private boolean isSending = true;

    private List<SocketAndBufferPair> buffersList = new LinkedList<>();

    public synchronized void addSendDataBuffer(SocketChannel socketChannel, ByteBuffer buffer) {
        buffersList.add(new SocketAndBufferPair(socketChannel, buffer));
        notifyAll();
    }

    public synchronized void waitNewBuffers() throws InterruptedException {
        while (buffersList.isEmpty()) {
            wait();
        }
    }

    public synchronized void sendingBuffer() throws InterruptedException {
        while (isSending) {
            waitNewBuffers();

            Iterator<SocketAndBufferPair> bufferIterator = buffersList.iterator();
            while (bufferIterator.hasNext()) {
//                ByteBuffer sendBuffer = bufferIterator.next();

//                if (!sendBuffer.hasRemaining()) {
//                    bufferIterator.remove();
//                }
            }
        }
    }

    @Override
    public void run() {
        try {
            sendingBuffer();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private class SocketAndBufferPair {
        public final SocketChannel socketChannel;
        public final ByteBuffer buffer;

        public SocketAndBufferPair(SocketChannel socketChannel, ByteBuffer buffer) {
            this.socketChannel = socketChannel;
            this.buffer = buffer;
        }
    }
}
