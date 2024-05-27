package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.ConnectFormDataContext;
import org.lab5.communication.TransferProtocol;

public class ConnectFormController implements SceneController {
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
        ConnectFormController.clientView = clientView;
    }

    @FXML
    public void clickOnContinueButton() {
        TransferProtocol currentTransferProtocol = TransferProtocol.SERIALIZABLE;
        if (XMLCheckBox.isSelected()) {
            currentTransferProtocol = TransferProtocol.XML;
        }

        ConnectFormDataContext connectFormDataContext = new ConnectFormDataContext(ipTextField.getText(),
                socketTextField.getText(), nicknameTextField.getText(), currentTransferProtocol);
        clientView.clickOnConnectButtonFromConnectForm(connectFormDataContext);
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
