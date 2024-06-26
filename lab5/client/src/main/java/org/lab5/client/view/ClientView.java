package org.lab5.client.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientListStatus;
import org.lab5.client.model.ClientModel;
import org.lab5.client.model.ChatAreaStatus;
import org.lab5.client.view.sceneControllers.ConnectFormController;
import org.lab5.client.view.sceneControllers.ClientsListController;
import org.lab5.client.view.sceneControllers.MainChatController;
import org.lab5.communication.ClientDataForReq;
import org.lab5.communication.MessageData;
import org.lab5.communication.NotificationData;
import org.lab5.communication.requests.notification.NotificationType;

import java.util.Timer;
import java.util.TimerTask;

public class ClientView {
    private ClientModel model;
    private ClientController controller;

    private Timer tickGenerator;
    private ViewStage viewStage = null;

    public ClientView() {
        ConnectFormController.setClientView(this);
        MainChatController.setClientView(this);
        ClientsListController.setClientView(this);
        JavaFxFrame.setClientView(this);
    }

    public void setModel(ClientModel model) {
        this.model = model;
    }

    public void setController(ClientController controller) {
        this.controller = controller;
    }

    public void clickOnConnectButtonFromConnectForm(ConnectFormDataContext connectFormDataContext) {
        model.setServerIP(connectFormDataContext.IP);
        model.setServerPort(Integer.parseInt(connectFormDataContext.socket));
        model.setNickname(connectFormDataContext.nickname);
        model.setTransferProtocol(connectFormDataContext.transferProtocol);
        controller.connectToServer();
    }

    public void clickOnSendButton(String message) {
        controller.sendMessage(message);
    }

    public void switchOnClientsListFromChat() {
        controller.getListOfClients();
    }

    public void showClientsList() {
        VBox vBoxListOfClients = JavaFxFrame.getClientsListController().getVBoxListOfClients();
        vBoxListOfClients.getChildren().clear();

        int i = 1;
        for (ClientDataForReq clientDataForReq : model.getClientDataList()) {
            Label label = new Label();
            label.setPrefHeight(17.0);
            label.setPrefWidth(595);
            label.setPadding(new Insets(0, 0, 10, 0));
            label.setFont(Font.font("Arial Bold", 15));
            label.setText(i++ + ": " + clientDataForReq.nickname + ";");
            vBoxListOfClients.getChildren().add(label);
        }

        JavaFxFrame.switchToClientsList();
        model.setClientListStatus(ClientListStatus.NOTHING);
    }

    public void showMessagesList() {
        VBox vBoxMessagesList = JavaFxFrame.getMainChatController().getVBoxMessagesList();
        vBoxMessagesList.getChildren().clear();

        for (MessageData messageData : model.getMessagesList()) {
            Label label = createLabelForMessage();

            String message = messageData.nickname + ": " + messageData.message;
            label.setText(message);

            vBoxMessagesList.getChildren().add(label);
        }

        model.setChatAreaStatus(ChatAreaStatus.NOTHING);
    }

    public void addMessage() {
        VBox vBoxMessagesList = JavaFxFrame.getMainChatController().getVBoxMessagesList();

        Label label = createLabelForMessage();

        MessageData messageData = model.getMessagesList().getLast();
        String message = messageData.nickname + ": " + messageData.message;
        label.setText(message);

        vBoxMessagesList.getChildren().add(label);

        model.setChatAreaStatus(ChatAreaStatus.NOTHING);
    }

    public void addNotification() {
        VBox vBoxMessagesList = JavaFxFrame.getMainChatController().getVBoxMessagesList();

        Label label = new Label();
        label.setMaxWidth(1.7976931348623157E308);
        label.setPrefHeight(17.0);
        label.setPrefWidth(305.0);
        label.setPadding(new Insets(5, 5, 5, 5));
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextOverrun(OverrunStyle.CLIP);
        label.setWrapText(true);
        label.setFont(Font.font("Arial Bold", 13));

        NotificationData notificationData = model.getNotificationList().getLast();
        String notificationText = "User " + notificationData.text;
        if (notificationData.notificationType == NotificationType.CONNECT) {
            notificationText += " connected.";
        } else if (notificationData.notificationType == NotificationType.DISCONNECT) {
            notificationText += " disconnected.";
        }
        label.setText(notificationText);

        vBoxMessagesList.getChildren().add(label);

        model.setChatAreaStatus(ChatAreaStatus.NOTHING);
    }

    private Label createLabelForMessage() {
        Label label = new Label();
        label.setMaxWidth(1.7976931348623157E308);
        label.setPrefHeight(17.0);
        label.setPrefWidth(305.0);
        label.setPadding(new Insets(3,3,3,3));
        label.setTextOverrun(OverrunStyle.CLIP);
        label.setWrapText(true);
        label.setFont(Font.font("Arial", 12));
        return label;
    }

    public void clickOnDisconnectButton() {
        controller.stopConnection();
        model.setViewStage(ViewStage.CONNECT_FORM);
    }

    public void switchOnChatFromClientsList() {
        JavaFxFrame.returnOnChatFromClientsList();
    }

    public void initialTickGenerator() {
        Task myTask = new Task();
        tickGenerator = new Timer();
        tickGenerator.scheduleAtFixedRate(myTask, 0, 1000 / 60);
    }

    private class Task extends TimerTask {
        @Override
        public void run() {
            Platform.runLater(() -> {
                ViewStage viewStageInModel = model.getViewStage();
                if (viewStage != viewStageInModel) {
                    switch (viewStageInModel) {
                        case CONNECT_FORM -> JavaFxFrame.switchToConnectFormScene();
                        case CHAT -> JavaFxFrame.switchToMainScene();
                    }
                    viewStage = viewStageInModel;
                }
                if (model.getClientListStatus() == ClientListStatus.EXIST) {
                    showClientsList();
                }
                if (model.getChatAreaStatus() == ChatAreaStatus.UPDATE_FULL_LIST) {
                    showMessagesList();
                } else if (model.getChatAreaStatus() == ChatAreaStatus.ADD_MESSAGE) {
                    addMessage();
                } else if (model.getChatAreaStatus() == ChatAreaStatus.ADD_NOTIFICATION) {
                    addNotification();
                }
            });
        }
    }

    public void closeApp() {
        tickGenerator.cancel();
        controller.stopConnection();
    }
}
