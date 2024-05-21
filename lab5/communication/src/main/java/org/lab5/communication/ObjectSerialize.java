package org.lab5.communication;

import org.lab5.communication.requests.Request;

import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;

public class ObjectSerialize {
    public static ByteBuffer createSendByteBuffer(Request request) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            byte[] req = bos.toByteArray();
            ByteBuffer buffer = ByteBuffer.wrap(req);
            return buffer;
        }
    }

    public static Request createReceiveRequest(byte[] receiveBytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveBytes))) {
            return (Request) ois.readObject();
        }
    }
}
