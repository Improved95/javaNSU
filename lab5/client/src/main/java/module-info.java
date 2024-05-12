module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.lab5.client.view to javafx.fxml;
    exports org.lab5.client.view;
}