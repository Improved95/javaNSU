package org.lab3.model;

import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ViewObserver;

public class SlashBladeModel extends ObserverModelAbstract {
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

    @Override
    public void update() {
        change();
    }

    @Override
    public void change() {
        currentGameMode.execute();
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (ViewObserver viewObserver : viewObservers) {
            viewObserver.update(this);
        }
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        currentGameMode = gameModesFactory.create(gameModeName);
    }
}
