package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.lab5.client.view.ClientView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsListController implements SceneController {
    private static ClientView clientView;

    @FXML
    private VBox vBoxListOfClients;

    public static void setClientView(ClientView clientView) {
        ClientsListController.clientView = clientView;
    }

    public VBox getVBoxListOfClients() {
        return vBoxListOfClients;
    }

    @FXML
    public void clickOnCloseButton() {
        clientView.switchOnChatFromClientsList();
    }
}
