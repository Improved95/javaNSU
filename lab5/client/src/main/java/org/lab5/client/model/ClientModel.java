package org.lab5.client.model;

import org.lab5.client.view.ViewStage;

import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private String serverIP;
    private int serverPort;
    private String nickname;

    private SocketChannel clientSocket;
    private boolean connectToServer = false;

    private ViewStage viewStage;

    private List<MessageType> messagesList = new ArrayList<>();

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverSocket) {
        this.serverPort = serverSocket;
    }

    public SocketChannel getClientSocketChannel() {
        return clientSocket;
    }

    public void setClientSocketChannel(SocketChannel clientSocket) {
        this.clientSocket = clientSocket;
    }

    public boolean isConnectToServer() {
        return connectToServer;
    }

    public void setConnectToServer(boolean connectToServer) {
        this.connectToServer = connectToServer;
    }

    public List<MessageType> getMessagesList() {
        return messagesList;
    }

    public ViewStage getViewStage() {
        return viewStage;
    }

    public void setViewStage(ViewStage viewStage) {
        this.viewStage = viewStage;
    }
}
