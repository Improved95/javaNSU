package org.lab5.client.view;

import javafx.application.Platform;
import org.lab5.client.client.Client;
import org.lab5.client.controller.ClientController;
import org.lab5.client.model.ClientModel;

import java.util.Timer;
import java.util.TimerTask;

public class ClientView {
    private ClientModel clientModel;
    private ClientController clientController;
    private Client clientWorkflow;

    private Timer tickGenerator;
    private ViewStage viewStage = null;

    public ClientView() {
        InputDataFormController.setClientView(this);
        JavaFxFrame.setClientView(this);
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void setClientWorkflow(Client clientWorkflow) {
        this.clientWorkflow = clientWorkflow;
    }

    public void clickOnContinueFromStartDataForm(FormDataContext formDataContext) {
        clientModel.setServerIP(formDataContext.IP);
        clientModel.setServerSocket(Integer.parseInt(formDataContext.socket));
        clientModel.setNickname(formDataContext.nickname);

        clientModel.setConnectToServer(true);
        clientWorkflow.wakeUp();
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
                ViewStage viewStageInModel = clientModel.getViewStage();
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
        tickGenerator.cancel();
        clientController.stopConnection();
    }
}
