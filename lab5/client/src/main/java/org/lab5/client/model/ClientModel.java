package org.lab5.client.model;

import org.lab5.client.view.ViewStage;
import org.lab5.communication.ClientData;
import org.lab5.communication.MessageData;
import org.lab5.communication.TransferProtocol;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private String serverIP;
    private int serverPort;
    private String nickname;

    private SocketChannel clientSocket;
    private boolean tryToConnectToServer = false;

    private List<ClientData> clientDataList = new ArrayList<>();
    private TransferProtocol transferProtocol;

    private ViewStage viewStage;
    private ClientListStatus clientListStatus = ClientListStatus.NO_REQUEST;

    private List<MessageData> messagesList = new ArrayList<>();

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

    public boolean isTryToConnectToServer() {
        return tryToConnectToServer;
    }

    public void setTryToConnectToServer(boolean connectToServer) {
        this.tryToConnectToServer = connectToServer;
    }

    public List<ClientData> getClientDataList() {
        return clientDataList;
    }

    public void setClientDataList(List<ClientData> clientDataList) {
        this.clientDataList = clientDataList;
    }

    public TransferProtocol getTransferProtocol() {
        return transferProtocol;
    }

    public void setTransferProtocol(TransferProtocol transferProtocol) {
        this.transferProtocol = transferProtocol;
    }

    public List<MessageData> getMessagesList() {
        return messagesList;
    }

    public ViewStage getViewStage() {
        return viewStage;
    }

    public void setViewStage(ViewStage viewStage) {
        this.viewStage = viewStage;
    }

    public ClientListStatus getClientListStatus() {
        return clientListStatus;
    }

    public void setClientListStatus(ClientListStatus clientListStatus) {
        this.clientListStatus = clientListStatus;
    }
}
