package org.lab3.model;

import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ViewObserver;
import org.lab3.slashBlade.JFrameObject;

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
    public void update(JFrameObject slashBladeJFrame) {
        changeModel(slashBladeJFrame);
    }

    @Override
    public void changeModel(JFrameObject slashBladeJFrame) {
        currentGameMode.execute();
        notifyObservers(slashBladeJFrame);
    }

    @Override
    public void notifyObservers(JFrameObject slashBladeJFrame) {
        for (ViewObserver viewObserver : viewObservers) {
            viewObserver.update(this, slashBladeJFrame);
        }
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        currentGameMode = gameModesFactory.create(gameModeName);
    }
}
