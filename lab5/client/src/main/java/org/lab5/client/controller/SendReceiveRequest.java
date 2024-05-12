package org.lab5.client.controller;

import org.lab5.client.requests.Request;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SendReceiveRequest {
    private static int bufferSize = 1024;
    private static ByteBuffer buffer= ByteBuffer.allocate(bufferSize);

    public static void sendRequest(SocketChannel socketChannel, Request request) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);) {
            oos.writeObject(request);
            byte[] req = bos.toByteArray();
            buffer = ByteBuffer.wrap(req);
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void receiveRequest(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        int bytesRead = socketChannel.read(buffer);
        byte[] receiveBytes = new byte[bytesRead];
        buffer.flip();
        buffer.get(receiveBytes);
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            Request request = (Request) in.readObject();
            System.out.println(request.requestType);
        }
    }
}
