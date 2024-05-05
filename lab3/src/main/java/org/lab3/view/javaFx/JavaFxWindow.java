package org.lab3.view.javaFx;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.Constants;
import org.lab3.slashBlade.FrameSize;

import java.awt.event.KeyListener;

public class JavaFxWindow extends Application {
    private static Stage stage;
    private static FrameSize frameSize;
    private static Scene scene;
    private static Group root;
    private static JavaFxView view;
    private static KeyListener keyListener;

    public static Scene getScene() {
        return scene;
    }

    public static void setFrameSize(FrameSize frameSize_) {
        frameSize = frameSize_;
    }

    public static void setKeyAndMouseListeners(JavaFxView view_, KeyListenerController keyListener_) {
        view = view_;
        keyListener = keyListener_;
    }

    public static void repaint() {
//        view.drawObject(root);
        root.requestLayout();
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
    }

    public static void close() {
        stage.close();
    }
}