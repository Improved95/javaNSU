package org.lab3.model;

import org.lab3.controller.Controller;
import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;

public class SlashBladeModel implements Model {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;

    public SlashBladeModel() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        this.gameModesFactory = new GameModesFactory();
        changeGameMode("LEVEL");
    }

    @Override
    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    public void changeModel(Controller controller) {
        currentGameMode.execute();
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        currentGameMode = gameModesFactory.create(gameModeName);
    }
}
