package org.lab3.model;

import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ViewObserver;

import java.lang.reflect.InvocationTargetException;

public class SlashBladeModel extends ObserverModelAbstract {
    private GameModesFactory gameModesFactory;
    private GameMode currentGameMode;

    public SlashBladeModel() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        this.gameModesFactory = new GameModesFactory();
        changeGameMode("LEVEL");
    }

    @Override
    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    @Override
    public void changeModel() {
        currentGameMode.execute();
    }

    @Override
    public void initial() {
        currentGameMode.initial();
    }

    @Override
    public void update() {
        changeModel();
    }

    @Override
    public void notifyObserversModifyDrawObjectList() {
        for (ViewObserver viewObserver : viewObservers) {
            viewObserver.updateDrawList(this);
        }
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        currentGameMode = gameModesFactory.create(gameModeName, this);
    }
}
