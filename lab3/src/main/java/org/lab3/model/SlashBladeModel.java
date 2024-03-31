package org.lab3.model;

import org.lab3.model.factories.GameModesFactory;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ViewObserver;
import org.lab3.slashBlade.FrameSize;

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
    public void initial() {
        currentGameMode.initial();
    }

    @Override
    public void updateKeyPressStatus(int keyCode) {
        currentGameMode.actionOnKeyPress(keyCode);
    }

    @Override
    public void updateKeyReleaseStatus(int keyCode) {
        currentGameMode.actionOnKeyReleased(keyCode);
    }

    @Override
    public void updateMouseKeyPressedStatus(int mouseKeyCode) {
        currentGameMode.actionOnMousePressed(mouseKeyCode);
    }

    @Override
    public void notifyObserversAddDrawObject(NeedDrawObject drawObject) {
        for (ViewObserver observer : viewObservers) {
            observer.addDrawObject(drawObject);
        }
    }

    @Override
    public void notifyObserversRemoveDrawObject(NeedDrawObject drawObject) {
        for (ViewObserver observer : viewObservers) {

        }
    }

    @Override
    public void changeModel(double currentFPS, FrameSize frameSize) {
        currentGameMode.execute(currentFPS, frameSize);
    }

    private void changeGameMode(String gameModeName) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        currentGameMode = gameModesFactory.create(gameModeName, this);
    }
}
