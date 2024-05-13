package org.lab5.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainChatController {
    private static ClientView clientView;

    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField messageTextField;

    public static void setClientView(ClientView clientView) {
        MainChatController.clientView = clientView;
    }

    public void clickOnSendButton() {

    }
}
