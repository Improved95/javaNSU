package org.lab3.controller.controller;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.controller.gameMode.factories.GameModesFactory;
import org.lab3.model.model.Model;

import java.lang.reflect.InvocationTargetException;

class SlashBladeLogicController  {
    private Model model;

    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;

    public SlashBladeLogicController() {
        this.gameModesFactory = new GameModesFactory();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void initial() {
        try {
            currentGameMode = gameModesFactory.create("LEVEL");
        } catch (ClassNotFoundException | IllegalAccessException |
                    InstantiationException | NoSuchMethodException | InvocationTargetException ex) {

            ex.printStackTrace();
        }
        model.setCurrentGameMode(currentGameMode);
        currentGameMode.initial();
    }

    public void calculateFrame(Model model) {

    }
}
