package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.lab5.client.view.ClientView;

public class ListOfClientsController {
    private static ClientView clientView;

    @FXML
    private VBox vBoxListOfClients;

    public static void setClientView(ClientView clientView) {
        ListOfClientsController.clientView = clientView;
    }

    public VBox getVbox() {
        return this.vBoxListOfClients;
    }

    @FXML
    public void clickOnCloseButton() {
        clientView.switchOnChatFromClientsList();
    }
}
