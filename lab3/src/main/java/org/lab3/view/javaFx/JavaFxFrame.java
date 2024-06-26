package org.lab3.view.javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.lab3.controller.controller.KeyListenerController;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;

public class JavaFxFrame extends Application {
    private static Stage stage;
    private static FrameSize frameSize;
    private static Scene scene;
    private static Group root;
    private static JavaFxView view = new JavaFxView();
    private static KeyListenerController keyListener;
    private static Canvas canvas;

    public static void setFrameSize(FrameSize frameSize_) {
        frameSize = frameSize_;
    }

    public static JavaFxView getView() {
        return view;
    }

    public static void setModel(Model model) {
        view.setModel(model);
    }

    public static void addInputListeners(KeyListenerController keyListener_) {
        keyListener = keyListener_;
    }

    public static void setDrawing() {
        stage.show();
    }

    public static void repaint() {
        view.drawObject(canvas);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void close() {
        Thread.currentThread().interrupt();
        stage.close();
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        root = new Group();
        scene = new Scene(root, frameSize.getWidth(), frameSize.getHeight());
        canvas = new Canvas(frameSize.getWidth(), frameSize.getHeight());
        root.getChildren().add(canvas);

        stage.setOnCloseRequest(event -> {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            stage.close();
        });
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("SlashBlade");
//        stage.show();
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
}