package org.lab5.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.lab5.communication.TransferProtocol;

public class InputDataFormController {
    public static ClientView clientView;

    @FXML
    private TextField ipTextField;
    @FXML
    private TextField socketTextField;
    @FXML
    private TextField nicknameTextField;

    @FXML
    private CheckBox serializationCheckBox;

    @FXML
    private CheckBox XMLCheckBox;

    public static void setClientView(ClientView clientView) {
        InputDataFormController.clientView = clientView;
    }

    @FXML
    public void clickOnContinueButton() {
        FormDataContext formDataContext = new FormDataContext(ipTextField.getText(),
                socketTextField.getText(), nicknameTextField.getText());
        clientView.clickOnContinueFromStartDataForm(formDataContext);

        clientView.setTransferProtocol(TransferProtocol.SERIALIZABLE);
        if (XMLCheckBox.isSelected()) {
            clientView.setTransferProtocol(TransferProtocol.XML);
        }
    }

    @FXML
    public void checkSerializationCheckBox() {
        XMLCheckBox.setSelected(false);
    }

    @FXML
    public void checkXMLCheckBox() {
        serializationCheckBox.setSelected(false);
    }
}
