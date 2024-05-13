module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires communication;

    opens org.lab5.client.view to javafx.fxml;
    exports org.lab5.client.view;
    exports org.lab5.client.view.sceneControllers;
    opens org.lab5.client.view.sceneControllers to javafx.fxml;
}