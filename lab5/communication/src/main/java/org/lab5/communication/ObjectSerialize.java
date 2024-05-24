package org.lab5.communication;

import org.lab5.communication.requests.Request;

import java.io.*;
import java.nio.ByteBuffer;

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

    public static Request createReceiveRequest(ByteBuffer receiveBytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveBytes.array()))) {
            return (Request) ois.readObject();
        }
    }
}
