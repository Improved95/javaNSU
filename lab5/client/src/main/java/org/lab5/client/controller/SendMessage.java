package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;

import java.io.*;

public class SendMessage {
    ClientModel clientModel;

    BufferedReader in;
    PrintWriter out;

    public void setClientModel(ClientModel clientModel) throws IOException {
        this.clientModel = clientModel;
        in = new BufferedReader(new InputStreamReader(clientModel.getClientSocket().getInputStream()));
        out = new PrintWriter(clientModel.getClientSocket().getOutputStream(), true);
    }

    public void sendReceiveMes() throws IOException {
        out.println("client_mes_1");
        System.out.println(in.readLine());

        out.println("client_mes_2");
        System.out.println(in.readLine());

        out.println(".");
        System.out.println(in.readLine());
    }
}
