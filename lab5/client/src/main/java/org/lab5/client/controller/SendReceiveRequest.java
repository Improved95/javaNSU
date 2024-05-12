package org.lab5.client.controller;

import org.lab5.connection.requests.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendReceiveRequest {
    public static void sendRequest(Socket socket, Request request) {
        System.out.println(request.requestType);
        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            oos.writeObject(request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void receiveRequest(Socket socket) {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
           Request request = (Request) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
