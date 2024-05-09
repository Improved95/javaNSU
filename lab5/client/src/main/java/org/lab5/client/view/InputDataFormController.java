package org.lab5.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InputDataFormController {
    public static ClientView clientView;

    @FXML
    private TextField ipTextField;
    @FXML
    private TextField socketTextField;
    @FXML
    private TextField nicknameTextField;

    public static void setClientView(ClientView clientView) {
        InputDataFormController.clientView = clientView;
    }

    @FXML
    public void clickOnContinueButton() {
        FormDataContext formDataContext = new FormDataContext();
        formDataContext.IP = ipTextField.getText();
        formDataContext.socket = socketTextField.getText();
        formDataContext.nickname = nicknameTextField.getText();
        clientView.clickOnContinueFromStartDataForm(formDataContext);

        JavaFxFrame.switchToMainScene();
    }
}
