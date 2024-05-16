package org.lab5.client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.lab5.client.view.sceneControllers.ClientsListController;
import org.lab5.client.view.sceneControllers.ConnectFormController;
import org.lab5.client.view.sceneControllers.MainChatController;
import org.lab5.client.view.sceneControllers.SceneController;

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
    private static Parent listOfClients;

    private static ConnectFormController connectFormController;
    private static MainChatController mainChatController;
    private static ClientsListController clientsListController;

    private static ClientView clientView;

    public static void setClientView(ClientView clientView) {
        JavaFxFrame.clientView = clientView;
    }

    public static ConnectFormController getConnectFormController() {
        return connectFormController;
    }

    public static MainChatController getMainChatController() {
        return mainChatController;
    }

    public static ClientsListController getClientsListController() {
        return clientsListController;
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

    public static void switchToClientsList() {
        StackPane stackPane = (StackPane) mainStage.getScene().getRoot();
        stackPane.getChildren().add(listOfClients);
    }

    public static void returnOnChatFromClientsList() {
        StackPane stackPane = (StackPane) mainStage.getScene().getRoot();
        stackPane.getChildren().remove(listOfClients);
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        mainStage.setTitle("Chat");

        initialConnectFormScene();
        initialMainChatScene();
        initialClientsListScene();

        mainStage.setOnCloseRequest((windowEvent) -> {
            clientView.closeApp();
            mainStage.close();
        });

        clientView.initialTickGenerator();
    }

    private void initialConnectFormScene() throws IOException {
        FXMLLoader connectFormLoader = new FXMLLoader(JavaFxFrame.class.getResource("connectForm.fxml"));
        connectForm = connectFormLoader.load();
        connectFormController = connectFormLoader.getController();
        StackPane inputDataFormLayout = new StackPane();
        inputDataFormLayout.getChildren().add(connectForm);
        connectFormScene = new Scene(inputDataFormLayout, 450, 200);
    }

    private void initialMainChatScene() throws IOException {
        FXMLLoader connectFormLoader = new FXMLLoader(JavaFxFrame.class.getResource("mainChat.fxml"));
        mainChat = connectFormLoader.load();
        mainChatController = connectFormLoader.getController();
        StackPane mainSceneLayout = new StackPane();
        mainSceneLayout.getChildren().add(mainChat);
        chatScene = new Scene(mainSceneLayout, 600, 400);
    }

    private void initialClientsListScene() throws IOException {
        FXMLLoader connectFormLoader = new FXMLLoader(JavaFxFrame.class.getResource("listOfClients.fxml"));
        listOfClients = connectFormLoader.load();
        clientsListController = connectFormLoader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}
