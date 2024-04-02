package org.lab3.controller.controller;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.controller.gameMode.factories.GameModesFactory;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

class SlashBladeLogicController {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;
    private Model model;

    SlashBladeLogicController() {
        this.gameModesFactory = new GameModesFactory();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    void initial() {
        try {
            currentGameMode = gameModesFactory.create("LEVEL", model);
        } catch (ClassNotFoundException | IllegalAccessException |
                    InstantiationException | NoSuchMethodException | InvocationTargetException ex) {

            ex.printStackTrace();
        }
        currentGameMode.initial();
    }

    void keyPressedObserver(int keyCode) {
        currentGameMode.actionOnKeyPressed(keyCode);
    }

    void keyReleasedObserver(int keyCode) {
        currentGameMode.actionOnKeyReleased(keyCode);
    }

    void mousePressedObserver(int keyCode) {
        currentGameMode.actionOnMousePressed(keyCode);
    }

    void calculateFrame(double currentFPS, FrameSize frameSize) {
        currentGameMode.execute(currentFPS, frameSize);
    }
}
