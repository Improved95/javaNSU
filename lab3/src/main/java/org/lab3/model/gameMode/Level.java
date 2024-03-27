package org.lab3.model.gameMode;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;

import java.util.*;

public class Level implements GameMode {
    private Model modelLoader;

    private Background background;
    private SamuraiV1 samurai;

    public Level(Model model) {
        this.modelLoader = model;
        this.background = new Background();
        this.samurai = new SamuraiV1();
    }

    @Override
    public void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList) {
        drawObjectsList.add(samurai);
        drawObjectsList.add(background);
    }

    @Override
    public void initial() {
        ResourcesContext samuraiImagesResources = new ResourcesContext();
        samuraiImagesResources.addImage("samurai/zero.png");
        this.samurai.getVisualContext().setImage(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        ResourcesContext backgroundImagesResources = new ResourcesContext();
        backgroundImagesResources.addImage("bg/bg1.jpg");
        this.background.getVisualContext().setImage(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        setSamurai();
        setBackground();

        modelLoader.notifyObserversModifyDrawObjectList();
    }

    @Override
    public void actionOnKeyPress(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                samurai.changeDirection(-1);
                samurai.changeRunStatus(true);
                break;
            case 83:
                break;
            case 68:
                samurai.changeDirection(1);
                samurai.changeRunStatus(true);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
            case 68:
                samurai.changeRunStatus(false);
                break;
            case 83:
                break;
        }
    }

    @Override
    public void execute(double currentFPS) {
        samurai.running2D(currentFPS);
    }

    private void setSamurai() {
        samurai.setScreenLayerLevel(1);
        samurai.setInGamePosition(100, 0);
        samurai.setScreenSize(100);
    }

    private void setBackground() {
        background.setScreenLayerLevel(0);
        background.setInGamePosition(0, -170);
        background.setScreenSize(115);
    }
}
