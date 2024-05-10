package org.lab5.client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxFrame extends Application {
    private static Stage mainStage;

    private static Scene mainScene;
    private static Scene inputDataScene;

    private static Parent mainChatSpace;
    private static Parent inputDataForm;

    private static ClientView clientView;

    public static void setClientView(ClientView clientView) {
        JavaFxFrame.clientView = clientView;
    }

    public static void switchToMainScene() {
        mainStage.setScene(mainScene);
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        inputDataForm = new FXMLLoader(JavaFxFrame.class.getResource("inputDataForm.fxml")).load();
        StackPane inputDataFormLayout = new StackPane();
        inputDataFormLayout.getChildren().add(inputDataForm);
        inputDataScene = new Scene(inputDataFormLayout, 450, 200);

        mainStage.setTitle("Chat");
        mainStage.setScene(inputDataScene);
        mainStage.show();

        mainChatSpace = new FXMLLoader(JavaFxFrame.class.getResource("mainSpace.fxml")).load();
        StackPane mainSceneLayout = new StackPane();
        mainSceneLayout.getChildren().add(mainChatSpace);
        mainScene = new Scene(mainSceneLayout, 600, 400);

        stage.setOnCloseRequest((windowEvent) -> {
            clientView.closeApp();
            mainStage.close();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
