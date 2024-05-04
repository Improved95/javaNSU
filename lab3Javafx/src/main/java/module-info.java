module org.lab3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.lab3 to javafx.fxml;
    exports org.lab3;
}