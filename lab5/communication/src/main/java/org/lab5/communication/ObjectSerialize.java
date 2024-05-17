package org.lab5.communication;

import org.lab5.communication.requests.Request;

import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;

public class ObjectSerialize {
    private final static int bufferSize = 1024 * 2;

    public static ByteBuffer createSendByteBuffer(Request request) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            byte[] req = bos.toByteArray();
            ByteBuffer buffer = ByteBuffer.wrap(req);
            return buffer;
        }
    }

    public static Request createRequestFromByteBuffer(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        ByteBuffer receiveBuffer = ByteBuffer.allocate(bufferSize);

        int bytesRead;
        try {
            bytesRead = socketChannel.read(receiveBuffer);
            System.out.println("bytes read " + bytesRead);
        } catch (SocketException | NotYetConnectedException | ClosedChannelException ex) {
            return null;
        }

        if (bytesRead == - 1) { return null; }

        byte[] receiveBytes = new byte[bytesRead];
        receiveBuffer.flip();
        receiveBuffer.get(receiveBytes);

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            return (Request) ois.readObject();
        }
    }
}
