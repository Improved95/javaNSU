package org.lab5.server.controller;

import org.lab5.server.requests.Request;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class SendReceiveRequest {
    private static int bufferSize = 1024 * 2;
    private static ByteBuffer buffer= ByteBuffer.allocate(bufferSize);

    public static void sendRequest(Socket socket, Request request) {
        /*try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public static void receiveRequest(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        try {
            int r = socketChannel.read(buffer);
            System.out.println(r);

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer.array()));
            Request request = (Request) ois.readObject();
            System.out.println("req type " + request.requestType);

            ois.close();
        } catch (IOException ex) {
            System.exit(-2);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.exit(-3);
            new RuntimeException(ex);
        }
    }
}
