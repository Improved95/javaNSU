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

import javax.imageio.ImageIO;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class JavaFxWindow extends Application {
    private FrameSize frameSize;
    private Scene scene;
    private Group root;
    private JavaFxView view;
    private KeyListener keyListener;

    public Scene getScene() {
        return scene;
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    public void setKeyAndMouseListeners(JavaFxView view, KeyListenerController keyListener) {
        this.view = view;
        this.keyListener = keyListener;
    }

    public void repaint() {
        view.drawObject(root);
        root.requestLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        scene = new Scene(root, 1650, 920);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SlashBlade");
        primaryStage.show();
    }

    private void setTestScene(Group root) throws IOException {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });


        InputStream imageStream = this.getClass().getResourceAsStream("../../../../SlashBladeResources/samurai/fifteen.png");
        BufferedImage fullImage = ImageIO.read(imageStream);
        Image image = SwingFXUtils.toFXImage(fullImage, null);

        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(50);
        imageView.setFitWidth(Constants.PlayerConstants.PLAYER_WIDTH);
        imageView.setFitHeight(Constants.PlayerConstants.PLAYER_HEIGHT);
        root.getChildren().add(imageView);
        root.getChildren().add(btn);


        scene.setOnKeyPressed(event -> {
            System.out.println(event.getCode().ordinal());
        });
    }
}