package org.lab5.client.model;

import org.lab5.client.view.ViewStage;
import org.lab5.communication.ClientDataForReq;
import org.lab5.communication.MessageData;
import org.lab5.communication.NotificationData;
import org.lab5.communication.TransferProtocol;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private String serverIP;
    private int serverPort;
    private String nickname;

    private SocketChannel clientSocket;

    private List<ClientDataForReq> clientDataForReqList = new ArrayList<>();
    private List<MessageData> messagesList = new ArrayList<>();
    private List<NotificationData> notificationList = new ArrayList<>();
    private TransferProtocol transferProtocol;

    private ViewStage viewStage;
    private ClientListStatus clientListStatus = ClientListStatus.NOTHING;
    private ChatAreaStatus chatAreaStatus = ChatAreaStatus.NOTHING;

//    private LoginStatus loginStatus;

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

    public List<ClientDataForReq> getClientDataList() {
        return clientDataForReqList;
    }

    public void setClientDataList(List<ClientDataForReq> clientDataForReqList) {
        this.clientDataForReqList = clientDataForReqList;
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

    public List<NotificationData> getNotificationList() {
        return notificationList;
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

    public ChatAreaStatus getChatAreaStatus() {
        return chatAreaStatus;
    }

    public void setChatAreaStatus(ChatAreaStatus chatAreaStatus) {
        this.chatAreaStatus = chatAreaStatus;
    }
}
