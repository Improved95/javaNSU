package org.lab3.model;

import org.lab3.controller.Controller;
import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;

public class SlashBladeModel extends ObserverModelAbstract {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;

    public SlashBladeModel(Controller controller) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        super(controller);
        this.gameModesFactory = new GameModesFactory();
        changeGameMode("LEVEL");
    }

    @Override
    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    @Override
    public void update() {

    }

    @Override
    public void change() {
        currentGameMode.execute();
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        currentGameMode = gameModesFactory.create(gameModeName);
    }
}
