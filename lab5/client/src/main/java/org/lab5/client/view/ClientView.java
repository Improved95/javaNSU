package org.lab5.client.view;

import org.lab5.client.controller.ClientController;

public class ClientView {
    private ClientController clientController;

    public ClientView() {
        InputDataFormController.setClientView(this);
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void clickOnContinueFromStartDataForm(FormDataContext formDataContext) {
        clientController.connectToServer(formDataContext);
    }
}
