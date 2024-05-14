package org.lab5.client.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.lab5.client.client.Client;
import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;
import org.lab5.client.view.sceneControllers.ConnectFormController;
import org.lab5.client.view.sceneControllers.ClientsListController;
import org.lab5.client.view.sceneControllers.MainChatController;
import org.lab5.communication.ClientData;
import org.lab5.communication.TransferProtocol;

import java.util.Timer;
import java.util.TimerTask;

public class ClientView {
    private ClientModel model;
    private ClientController controller;
    private Client clientWorkflow;

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

    public void setClientWorkflow(Client clientWorkflow) {
        this.clientWorkflow = clientWorkflow;
    }

    public void clickOnContinueFromStartDataForm(FormDataContext formDataContext) {
        model.setServerIP(formDataContext.IP);
        model.setServerPort(Integer.parseInt(formDataContext.socket));
        model.setNickname(formDataContext.nickname);

        model.setTryToConnectToServer(true);
        clientWorkflow.wakeUp();
    }

    public void clickOnSendButton(String message) {
        controller.sendMessage(message);
    }

    public void switchOnClientsListFromChat() {
        controller.getListOfClients();

        VBox vBoxListOfClients = ClientsListController.getVBoxListOfClients();

        int i = 0;
        for (ClientData clientData : model.getClientDataList()) {
            Label label = new Label();
            label.setPrefHeight(17.0);
            label.setPrefWidth(595);
            label.setFont(Font.font("Arial Bold", 15));
            label.setText(i++ + ": Nickname: " + clientData.getNickname());
            System.out.println(vBoxListOfClients);
//            vBoxListOfClients.getChildren().add(label);
        }

        JavaFxFrame.switchToClientsList();
    }

    public void switchOnChatFromClientsList() {
        JavaFxFrame.returnOnChatFromClientsList();
    }

    public void setTransferProtocol(TransferProtocol transferProtocol) {
        model.setTransferProtocol(transferProtocol);
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
            });
        }
    }

    public void closeApp() {
        clientWorkflow.setStopTryConnect(true);
        clientWorkflow.wakeUp();
        tickGenerator.cancel();
        controller.stopConnection();
    }
}
