package org.lab3.view.javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

import java.awt.event.KeyListener;

public class JavaFxWindow extends Application {
    private static Stage stage;
    private static FrameSize frameSize;
    private static Scene scene;
    private static Group root;
    private static JavaFxView view;
    private static KeyListener keyListener;

//    public static Scene getScene() {
//        return scene;
//    }

    public static void setFrameSize(FrameSize frameSize_) {
        frameSize = frameSize_;
    }

    public static void setView(JavaFxView view_) {
        view = view_;
    }

    public static void setInputListeners(KeyListenerController keyListener_) {
        keyListener = keyListener_;
    }

    public static void repaint() {
        System.out.println("here");
//        view.drawObject(root);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        root = new Group();
        scene = new Scene(root, frameSize.getWidth(), frameSize.getHeight());

        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("SlashBlade");
        stage.show();
        view.notifyAll();
    }

    public void setTestScene(Group root, Scene scene) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        root.getChildren().add(btn);
    }

    public static void close() {
        stage.close();
    }
}