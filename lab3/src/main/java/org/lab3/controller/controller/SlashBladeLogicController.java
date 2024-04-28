package org.lab3.controller.controller;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.controller.factories.GameModesFactory;
import org.lab3.controller.gameMode.GameState;
import org.lab3.model.model.Model;
import org.lab3.view.View;

import java.lang.reflect.InvocationTargetException;

class SlashBladeLogicController {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;
    private Model model;
    private View view;

    SlashBladeLogicController() {
        this.gameModesFactory = new GameModesFactory();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    void initial() {
        try {
            currentGameMode = gameModesFactory.create("LEVEL", model);
        } catch (ClassNotFoundException | IllegalAccessException |
                    InstantiationException | NoSuchMethodException | InvocationTargetException ex) {

            ex.printStackTrace();
        }
        model.setGameState(GameState.LEVEL1);
        view.switchGameStateResources();
    }

    void keyPressedObserver(int keyCode) {
        currentGameMode.actionOnKeyPressed(keyCode);
    }

    void keyReleasedObserver(int keyCode) {
        currentGameMode.actionOnKeyReleased(keyCode);
    }

    void mousePressedObserver(int keyCode, int posX, int posY) {
        currentGameMode.actionOnMousePressed(keyCode, posX, posY);
    }

    int calculateFrame(double currentFPS) {
        int returnValue = currentGameMode.execute(currentFPS);
        if (returnValue == 1) {
            return 1;
        }
        return 0;
    }
}
