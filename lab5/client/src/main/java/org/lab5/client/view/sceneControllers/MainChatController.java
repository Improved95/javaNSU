package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.lab5.client.view.ClientView;

public class MainChatController implements SceneController {
    private static ClientView clientView;

    @FXML
    private VBox vBoxMessagesList;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextField messageTextField;

    public static void setClientView(ClientView clientView) {
        MainChatController.clientView = clientView;
    }

    public VBox getVBoxMessagesList() {
        return vBoxMessagesList;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void clickOnSendButton() {
        clientView.clickOnSendButton(messageTextField.getText());
        messageTextField.setText("");
        messageTextField.requestFocus();
    }

    @FXML
    public void clickOnGetClientsListButton() {
        clientView.switchOnClientsListFromChat();
    }

    @FXML
    public void clickOnDisconnectButton() {

    }
}
