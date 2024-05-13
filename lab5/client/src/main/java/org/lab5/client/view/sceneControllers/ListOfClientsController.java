package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.lab5.client.view.ClientView;

public class ListOfClientsController {
    private static ClientView clientView;

    @FXML
    private static VBox vBoxListOfClients;

    public static void setClientView(ClientView clientView) {
        ListOfClientsController.clientView = clientView;
    }

    public static VBox getVBoxListOfClients() {
        return vBoxListOfClients;
    }

    @FXML
    public void clickOnCloseButton() {
        clientView.switchOnChatFromClientsList();
    }
}
