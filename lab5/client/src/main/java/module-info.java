module org.lab5.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.lab5.connection;

    opens org.lab5.client.view to javafx.fxml;
    exports org.lab5.client.view;
}