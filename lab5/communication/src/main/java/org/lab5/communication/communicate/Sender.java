package org.lab5.communication.communicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Sender implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(Sender.class);

    private boolean isSending = true;

    private ConcurrentLinkedQueue<SocketAndDequeBufferPair> socketAndDequeBufferPairs = new ConcurrentLinkedQueue<>();

    private boolean socketChannelIsExist(SocketChannel socketChannel) {
        for (SocketAndDequeBufferPair socketAndDequeBufferPair : socketAndDequeBufferPairs) {
            if (socketAndDequeBufferPair.socketChannel.equals(socketChannel)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void addSendDataBuffer(SocketChannel socketChannel, ByteBuffer buffer) {
        if (socketChannelIsExist(socketChannel)) {
            for (SocketAndDequeBufferPair socketAndDequeBufferPair : socketAndDequeBufferPairs) {
                if (socketAndDequeBufferPair.socketChannel.equals(socketChannel)) {
                    socketAndDequeBufferPair.addBuffer(buffer);
                }
            }
        } else {
            SocketAndDequeBufferPair socketAndDequeBufferPair = new SocketAndDequeBufferPair(socketChannel);
            socketAndDequeBufferPair.addBuffer(buffer);
            socketAndDequeBufferPairs.add(socketAndDequeBufferPair);
        }
        notifyAll();
    }

    private boolean buffersListIsEmpty() {
        for (SocketAndDequeBufferPair socketAndDequeBufferPair : socketAndDequeBufferPairs) {
            if (!socketAndDequeBufferPair.bufferDeque.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void waitNewBuffers() throws InterruptedException {
        while (buffersListIsEmpty()) {
//            System.out.println("waitNewBuffers");
            wait();
            if (!isSending) {
                break;
            }
        }
    }

    private synchronized void sendingBuffer() throws InterruptedException, IOException {
        while (isSending) {
            waitNewBuffers();

            for (SocketAndDequeBufferPair socketAndDequeBufferPair : socketAndDequeBufferPairs) {
                if (socketAndDequeBufferPair.bufferDeque.isEmpty()) {
                    continue;
                }
                SocketChannel socketChannel = socketAndDequeBufferPair.socketChannel;
                ByteBuffer buffer = socketAndDequeBufferPair.bufferDeque.getFirst();

                socketChannel.write(buffer);
                logger.info("write in socket {}, buffer {} with size {}", socketChannel, buffer, buffer.capacity());
                if (!buffer.hasRemaining()) {
                    socketAndDequeBufferPair.bufferDeque.removeFirst();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            sendingBuffer();
        } catch (InterruptedException | IOException ex) {
            logger.error("exception in buffer sender ", ex);
        }
    }

    public synchronized void stopSendData() {
        isSending = false;
        notifyAll();
    }

    private class SocketAndDequeBufferPair {
        public final SocketChannel socketChannel;
        public final Deque<ByteBuffer> bufferDeque = new ArrayDeque<>();

        public void addBuffer(ByteBuffer buffer) {
            bufferDeque.addFirst(buffer);
        }

        public SocketAndDequeBufferPair(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }
    }
}
