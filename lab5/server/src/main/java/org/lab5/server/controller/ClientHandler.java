package org.lab5.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket clientSocket;

    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String inputLine ;
                if ((inputLine = in.readLine()) != null) {
                    if (inputLine.equals(".")) {
                        break;
                    }
                    System.out.println(inputLine);
                    out.println("receive form server: " + inputLine);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            out.println("close connection");
            clientSocket.close();
            in.close();
            out.close();
            Thread.currentThread().interrupt();
            System.out.println("thread interrupt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
