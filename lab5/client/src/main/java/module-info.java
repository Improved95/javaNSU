module org.lab5.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires com.almasb.fxgl.all;

    opens org.lab5.client.view to javafx.fxml;
    exports org.lab5.client.view;
}