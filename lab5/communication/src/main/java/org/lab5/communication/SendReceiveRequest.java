package org.lab5.communication;

import org.lab5.communication.requests.Request;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SendReceiveRequest {
    private static int bufferSize = 1024 * 2;
    private static ByteBuffer buffer= ByteBuffer.allocate(bufferSize);

    public static void sendRequest(SocketChannel socketChannel, Request request) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            byte[] req = bos.toByteArray();
            ByteBuffer buffer = ByteBuffer.wrap(req);
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Request receiveRequest(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        buffer.clear();
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead == - 1) {
            return null;
        }

        byte[] receiveBytes = new byte[bytesRead];
        buffer.flip();
        buffer.get(receiveBytes);
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            return (Request) in.readObject();
        }
    }
}
