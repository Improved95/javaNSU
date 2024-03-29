package org.lab3.model.gameMode;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.Character;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;

import java.util.*;

public class Level implements GameMode {
    private Model modelLoader;

    private CharacterMovementController characterMovementController = new CharacterMovementController();
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
//        System.out.println("Action");
        switch (keyCode) {
            case 87:
                break;
            case 65:
                characterMovementController.changeMoveX(samurai, 1, -1);
                break;
            case 83:
                break;
            case 68:
                characterMovementController.changeMoveX(samurai, -1, 1);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                characterMovementController.changeMoveX(samurai, 0, -1);
                break;
            case 83:
                break;
            case 68:
                characterMovementController.changeMoveX(samurai, -1, 0);
                break;
        }
    }

    @Override
    public void execute(double currentFPS) {
        samurai.moveX(currentFPS);
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

class CharacterMovementController {
    public int aIsPress = 0;
    public int dIsPress = 0;

    public void changeMoveX(Character character, int a, int d) {
        System.out.println(a + " " + d);
        if (a == 1) {
            if (dIsPress != 1) {
                character.changeDirection(-1);
                character.changeMoveXStatus(true);
            } else {
                character.changeMoveXStatus(false);
            }
            aIsPress = a;
        }
        if (d == 1) {
            if (aIsPress != 1) {
                character.changeDirection(1);
                character.changeMoveXStatus(true);
                dIsPress = d;
            } else {
                character.changeMoveXStatus(false);
            }
            dIsPress = d;
        }
        if (a == 0) {
            if (dIsPress == 1) {
                character.changeDirection(1);
                character.changeMoveXStatus(true);
            }
            aIsPress = a;
        }
        if (d == 0) {
            if (aIsPress == 1) {
                character.changeDirection(-1);
                character.changeMoveXStatus(true);
            }
            dIsPress = d;
        }
        if ((aIsPress == 0 && dIsPress == 0) || (aIsPress == 1 && dIsPress == 1)) {
            character.changeMoveXStatus(false);
        }
    }
}
