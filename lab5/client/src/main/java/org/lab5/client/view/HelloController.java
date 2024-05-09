package org.lab5.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea chatArea;

    @FXML
    protected void disconnectButtonClick() {
        System.out.println(chatArea.getText());
    }
}