package org.lab3.controller.gameMode.level;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.resources.ResourcesContext;
import org.lab3.slashBlade.FrameSize;

public class Level implements GameMode {
    private Model model;
    private LevelObjectsContext levelObjectsContext = new LevelObjectsContext();;

    private ResourcesContext samuraiImagesResources;
    private ResourcesContext backgroundImagesResources;
    private ResourcesContext enemyImagesResources;

    private EnemyCreator<SamuraiV1> enemyCreator = new EnemyCreator();

    private Level(Model model) {
        this.model = model;
        this.model.setGameModeObjectscontext(this.levelObjectsContext);
    }

    @Override
    public void initial() {
        this.samuraiImagesResources = new ResourcesContext();
        samuraiImagesResources.addImage("samurai/zero.png");
        levelObjectsContext.getPlayer().setImage(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        this.backgroundImagesResources = new ResourcesContext();
        backgroundImagesResources.addImage("bg/bg1.jpg");
        levelObjectsContext.getBackground().setImage(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        enemyImagesResources = new ResourcesContext();
        enemyImagesResources.addImage("samurai/enemy.png");

        setPlayer(levelObjectsContext.getPlayer());
        setBackground(levelObjectsContext.getBackground());
        enemyCreator.setTimer(2000);

//        modelLoader.notifyObserversAddDrawObject(player);
//        modelLoader.notifyObserversAddDrawObject(background);
    }

    @Override
    public void actionOnKeyPressed(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
//                characterMovementController.changeMoveX(player, 1, -1);
                break;
            case 83:
                break;
            case 68:
//                characterMovementController.changeMoveX(player, -1, 1);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
//                characterMovementController.changeMoveX(player, 0, -1);
                break;
            case 83:
                break;
            case 68:
//                characterMovementController.changeMoveX(player, -1, 0);
                break;
        }
    }

    @Override
    public void actionOnMousePressed(int mouseKeyCode) {
        if (mouseKeyCode == 1) {
//            characterMovementController.changeAttack(player);
        }
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
//        playerMove(currentFPS, frameSize);

        /*SamuraiV1 enemy = enemyCreator.create(enemyList, enemyImagesResources, currentFPS);
        if (enemy != null) {
//            modelLoader.notifyObserversAddDrawObject(enemy);
            System.out.println("new enemy");

            Random random = new Random();
            if (random.nextInt() % 2 == 1) {
                SamuraiV1 removedEnemy = enemyList.remove(0);
                System.out.println("remove enemy");
//                modelLoader.notifyObserversRemoveDrawObject(removedEnemy);
            }
        }*/

    }

    private void playerMove(double currentFPS, FrameSize frameSize) {
//        player.getMovementList().get("MOVE_X").execute(currentFPS, frameSize);
//        player.getMovementList().get("ATTACK").execute(currentFPS, frameSize);
    }

    private void setPlayer(SlashBladeCharacterAbstract slashBladeCharacter) {
        slashBladeCharacter.setScreenLayerLevel(1);
        slashBladeCharacter.getParametersContext().setHealth(3);
        slashBladeCharacter.setInGamePosition(100, 0);
        slashBladeCharacter.setScreenSize(90);
    }

    private void setBackground(SlashBladeObjectAbstract slashBladeObject) {
        slashBladeObject.setScreenLayerLevel(0);
        slashBladeObject.setInGamePosition(0, -170);
        slashBladeObject.setScreenSize(115);
    }
}
