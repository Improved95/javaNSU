package org.lab3.model.gameMode.level;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.LinkedSetDrawObjects;

import java.util.*;

public class Level implements GameMode {
    private Model modelLoader;

    private EnemyCreator enemyCreator = new EnemyCreator();
    private CharacterMovementController characterMovementController = new CharacterMovementController();
    private Background background;
    private SamuraiV1 player;

    ResourcesContext enemyImagesResources;
    ArrayList<SamuraiV1> enemyList = new ArrayList<>();

    private Level(Model model) {
        this.modelLoader = model;
        this.background = new Background();
        this.player = new SamuraiV1();
    }

    @Override
    public void getDrawObjectsList(LinkedSetDrawObjects drawObjectsList) {
        drawObjectsList.add(player);
        drawObjectsList.add(background);
        for (SamuraiV1 enemy : enemyList) {
            drawObjectsList.add(enemy);
        }
    }

    @Override
    public void initial() {
        ResourcesContext samuraiImagesResources = new ResourcesContext();
        samuraiImagesResources.addImage("samurai/zero.png");
        this.player.getVisualContext().setImage(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        ResourcesContext backgroundImagesResources = new ResourcesContext();
        backgroundImagesResources.addImage("bg/bg1.jpg");
        this.background.getVisualContext().setImage(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        enemyImagesResources = new ResourcesContext();
        enemyImagesResources.addImage("samurai/enemy.png");

        setSamurai();
        setBackground();
        enemyCreator.setTimer(2000);

        modelLoader.notifyObserversModifyDrawObjectList();
    }

    @Override
    public void actionOnKeyPress(int keyCode) {
//        System.out.println("Action");
        switch (keyCode) {
            case 87:
                break;
            case 65:
                characterMovementController.changeMoveX(player, 1, -1);
                break;
            case 83:
                break;
            case 68:
                characterMovementController.changeMoveX(player, -1, 1);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                characterMovementController.changeMoveX(player, 0, -1);
                break;
            case 83:
                break;
            case 68:
                characterMovementController.changeMoveX(player, -1, 0);
                break;
        }
    }

    @Override
    public void actionOnMousePressed(int mouseKeyCode) {
        if (mouseKeyCode == 1) {
            characterMovementController.changeAttack(player);
        }
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        playerMove(currentFPS, frameSize);
        if (enemyCreator.create(enemyList, enemyImagesResources, currentFPS)) {
            modelLoader.notifyObserversModifyDrawObjectList();
            System.out.println("new enemy");
        }

    }

    private void playerMove(double currentFPS, FrameSize frameSize) {
        player.getMovementList().get("MOVE_X").execute(currentFPS, frameSize);
        player.getMovementList().get("ATTACK").execute(currentFPS, frameSize);
    }

    private void setSamurai() {
        player.setScreenLayerLevel(1);
        player.getParametersContext().setHealth(3);
        player.setInGamePosition(100, 0);
        player.setScreenSize(90);
    }

    private void setBackground() {
        background.setScreenLayerLevel(0);
        background.setInGamePosition(0, -170);
        background.setScreenSize(115);
    }
}
