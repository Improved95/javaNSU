package org.lab5.communication;

import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.SetTransportProtocolReq;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class SendReceiveRequest {
    private static int bufferSize = 1024 * 2;

    public static void broadCast(Set<SocketChannel> socketChannelSet, Request request) {
        for (SocketChannel socketChannel : socketChannelSet) {
            sendRequest(socketChannel, request);
        }
    }

    public static void sendRequest(SocketChannel socketChannel, Request request) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            byte[] req = bos.toByteArray();
            ByteBuffer buffer = ByteBuffer.wrap(req);
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Request receiveRequest(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        ByteBuffer receiveBuffer = ByteBuffer.allocate(bufferSize);
        int bytesRead = socketChannel.read(receiveBuffer);
        if (bytesRead == - 1) { return null; }

        if (bytesRead == 1) {
            return new SetTransportProtocolReq();
        }

        byte[] receiveBytes = new byte[bytesRead];
        receiveBuffer.flip();
        receiveBuffer.get(receiveBytes);
        System.out.println("bytes read " + bytesRead);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            return (Request) ois.readObject();
        }
    }
}
