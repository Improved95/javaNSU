package org.lab5.client.view.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.lab5.client.view.ClientView;
import org.lab5.client.view.FormDataContext;
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
