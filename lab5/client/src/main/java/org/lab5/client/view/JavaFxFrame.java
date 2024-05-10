package org.lab5.client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class JavaFxFrame extends Application {
    private static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    private static Stage mainStage;

    private static Scene chatScene;
    private static Scene connectFormScene;

    private static Parent mainChat;
    private static Parent connectForm;

    private static ClientView clientView;

    public static void setClientView(ClientView clientView) {
        JavaFxFrame.clientView = clientView;
    }

    public static void switchToConnectFormScene() {
        switchScene(connectFormScene);
    }

    public static void switchToMainScene() {
        switchScene(chatScene);
    }

    private static void switchScene(Scene connectFormScene) {
        mainStage.setScene(connectFormScene);

        double sceneWidth = connectFormScene.getWidth();
        double sceneHeight = connectFormScene.getHeight();
        mainStage.setX(screenWidth / 2 - sceneWidth / 2);
        mainStage.setY(screenHeight / 2 - sceneHeight / 2);

        mainStage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        mainStage.setTitle("Chat");

        connectForm = new FXMLLoader(JavaFxFrame.class.getResource("inputDataForm.fxml")).load();
        StackPane inputDataFormLayout = new StackPane();
        inputDataFormLayout.getChildren().add(connectForm);
        connectFormScene = new Scene(inputDataFormLayout, 450, 200);

        mainChat = new FXMLLoader(JavaFxFrame.class.getResource("mainChat.fxml")).load();
        StackPane mainSceneLayout = new StackPane();
        mainSceneLayout.getChildren().add(mainChat);
        chatScene = new Scene(mainSceneLayout, 600, 400);

        stage.setOnCloseRequest((windowEvent) -> {
            clientView.closeApp();
            mainStage.close();
        });

        clientView.initialTickGenerator();
    }

    public static void main(String[] args) {
        launch();
    }
}
