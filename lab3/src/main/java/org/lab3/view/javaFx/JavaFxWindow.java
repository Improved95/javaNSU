package org.lab3.view.javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class JavaFxWindow extends Application {
    public static void main(String args[]) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Hello, JavaFx " + javafxVersion + ", running on Java " + javaVersion + ".");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(l);
        Scene scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
