module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires communication;
//    requires log4j.api;
    requires org.apache.logging.log4j;

    opens org.lab5.client.view to javafx.fxml;
    exports org.lab5.client.view;
    exports org.lab5.client.view.sceneControllers;
    opens org.lab5.client.view.sceneControllers to javafx.fxml;
}