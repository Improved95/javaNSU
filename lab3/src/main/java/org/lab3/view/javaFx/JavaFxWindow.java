package org.lab3.view.javaFx;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.lab3.slashBlade.Constants;
import org.lab3.slashBlade.FrameSize;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class JavaFxWindow extends Application {
    private static FrameSize frameSize;
    Scene scene;

    public static void setFrameSize(FrameSize frameSize_) {
        frameSize = frameSize_;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Group root = new Group();

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

        scene = new Scene(root, frameSize.getWidth(), frameSize.getHeight());
        scene.setOnKeyPressed(event -> {
            System.out.println(event.getCode().ordinal());
        });

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }
}