package org.lab3.slashBlade;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.controller.factories.GameModesFactory;
import org.lab3.controller.gameMode.GameState;
import org.lab3.model.model.Model;
import org.lab3.view.View;

import java.lang.reflect.InvocationTargetException;

import static org.lab3.slashBlade.Constants.ViewConstants.definitionForJavaFx;
import static org.lab3.slashBlade.Constants.ViewConstants.definitionForSwing;

public class LogicController {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;
    private Model model;
    private View swingView;
    private View javaFxView;

    public LogicController() {
        this.gameModesFactory = new GameModesFactory();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setSwingView(View view) {
        this.swingView = view;
    }

    public void setJavaFxView(View javaFxView) {
        this.javaFxView = javaFxView;
    }

    public void initial() {
        try {
            currentGameMode = gameModesFactory.create("LEVEL", model);
        } catch (ClassNotFoundException | IllegalAccessException |
                    InstantiationException | NoSuchMethodException | InvocationTargetException ex) {

            ex.printStackTrace();
        }
        model.setGameState(GameState.LEVEL1);
        if (definitionForSwing())
            swingView.switchGameStateResources();
        if (definitionForJavaFx())
            javaFxView.switchGameStateResources();
    }

    public void keyPressedObserver(int keyCode) {
        currentGameMode.actionOnKeyPressed(keyCode);
    }

    public void keyReleasedObserver(int keyCode) {
        currentGameMode.actionOnKeyReleased(keyCode);
    }

    public void mousePressedObserver(int keyCode, int posX, int posY) {
        currentGameMode.actionOnMousePressed(keyCode, posX, posY);
    }

    public int calculateFrame(double currentFPS) {
        int returnValue = currentGameMode.execute(currentFPS);
        if (returnValue == Constants.GameConstants.EXIT_GAME) {
            return Constants.GameConstants.EXIT_GAME;
        }
        return Constants.GameConstants.NOTHING_DOING;
    }
}
