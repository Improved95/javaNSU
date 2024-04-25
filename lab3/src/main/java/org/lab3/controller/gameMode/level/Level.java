package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.SlashFX.SlashFXController;
import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.playerActions.PlayerAction;
import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.SlashBladeObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.slashFX.SlashFX;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.util.ArrayList;
import java.util.List;

public class Level implements GameMode {
    private Model model;
    private LevelObjectsContext levelObjectsContext;
//    private JFrameObject jFrameObject;

    private LevelResourcesContext levelResourcesContext = new LevelResourcesContext();

    private EnemyCreator enemyCreator = new EnemyCreator();

    private AllCharactersActionsContext actionsContext = new AllCharactersActionsContext();

    private Level(Model model) {
        this.model = model;
        levelObjectsContext  = new LevelObjectsContext();
        this.model.setGameModeObjectsContext(levelObjectsContext);
    }

    @Override
    public void actionOnKeyPressed(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                actionsContext.getPlayerActionController().changeMoveX(1, -1);
                break;
            case 83:
                break;
            case 68:
                actionsContext.getPlayerActionController().changeMoveX(-1, 1);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                actionsContext.getPlayerActionController().changeMoveX(0, -1);
                break;
            case 83:
                break;
            case 68:
                actionsContext.getPlayerActionController().changeMoveX(-1, 0);
                break;
        }
    }

    @Override
    public void actionOnMousePressed(int mouseKeyCode) {
        if (mouseKeyCode == 1) {
            actionsContext.getPlayerActionController().attack();
        }
    }

    @Override
    public int execute(double currentFPS) {
        actionsContext.getPlayerActionController().nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        actionsContext.getSlashFXController().nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        for (EnemyAction enemyActionController : actionsContext.getEnemyActionsControllers()) {
            enemyActionController.nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        }

        enemyCreator.create(levelObjectsContext.getEnemyList(), actionsContext,
                levelResourcesContext.getEnemyImagesResources(), model.getFrameSize(), currentFPS);

        deleteObjectsFromGame();

        if (levelObjectsContext.getPlayer().getParametersContext().getHealth() <= 0) {
            return 1;
        }

        return 0;
    }

    private void deleteObjectsFromGame() {
        List<SlashBladeObject> deleteEnemyList = new ArrayList<>();
        List<EnemyAction> deleteEnemyActionControllersList = new ArrayList<>();
        for (SlashBladeObject enemy : levelObjectsContext.getEnemyList()) {
            if (!enemy.isGameObjectIsExist()) {
                deleteEnemyList.add(enemy);
                for (EnemyAction enemyActionController : actionsContext.getEnemyActionsControllers()) {
                    if (enemyActionController.getCharacter().equals(enemy)) {
                        deleteEnemyActionControllersList.add(enemyActionController);
                    }
                }
            }
        }
        levelObjectsContext.getEnemyList().removeAll(deleteEnemyList);
        actionsContext.getEnemyActionsControllers().removeAll(deleteEnemyActionControllersList);
    }

    @Override
    public void initial() {
        openResources();
        setPlayer();
        setBackground();
        setFx();
        enemyCreator.setCreateDelay(2000);
    }

    private void openResources() {
        levelResourcesContext.getPlayerImagesResources().addImage("samurai/zero.png");
        levelResourcesContext.getBackgroundImagesResources().addImage("bg/bg1.jpg");
        levelResourcesContext.getEnemyImagesResources().addImage("samurai/enemy.png");
        levelResourcesContext.getSlashFxImageResources().addImage("fx/slash.png");
    }

    private void setPlayer() {
        levelObjectsContext.setPlayer(new SamuraiV1());
        levelObjectsContext.getPlayer().setImage(levelResourcesContext.getPlayerImagesResources().getOpenedResourcesList().get(0).getOpenedImage());

        actionsContext.setPlayerActionController(new PlayerAction(levelObjectsContext.getPlayer()));

        levelObjectsContext.getPlayer().setScreenLayerLevel(1);
        levelObjectsContext.getPlayer().setInGamePosition(model.getFrameSize().getWidth() / 2, 0);
        levelObjectsContext.getPlayer().getParametersContext().setRadiusForwardAttack(100);
        levelObjectsContext.getPlayer().getParametersContext().setRadiusBackwardAttack(10);
    }

    private void setBackground() {
        levelObjectsContext.setBackground(new Background());
        levelObjectsContext.getBackground().setImage(levelResourcesContext.getBackgroundImagesResources().getOpenedResourcesList().get(0).getOpenedImage());

        levelObjectsContext.getBackground().setScreenLayerLevel(0);
        levelObjectsContext.getBackground().setInGamePosition(0, -170);
        levelObjectsContext.getBackground().setScreenSize(115);
    }

    private void setFx() {
        levelObjectsContext.setSlashFX(new SlashFX());
        levelObjectsContext.getSlashFX().setImage(levelResourcesContext.getSlashFxImageResources().getOpenedResourcesList().get(0).getOpenedImage());
        levelObjectsContext.getSlashFX().setGameObjectIsExist(false);

        levelObjectsContext.getSlashFX().setScreenSize(70);
        levelObjectsContext.getSlashFX().setDrawImageOnMiddle(true);

        actionsContext.setSlashFXController(new SlashFXController(levelObjectsContext.getSlashFX()));
    }
}
