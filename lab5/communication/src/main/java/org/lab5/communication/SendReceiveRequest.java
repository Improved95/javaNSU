package org.lab5.communication;

import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.TransportProtocolReq;

import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
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

        if (bytesRead == 1) {
            return new TransportProtocolReq(receiveBytes[0]);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            return (Request) ois.readObject();
        }
    }
}
