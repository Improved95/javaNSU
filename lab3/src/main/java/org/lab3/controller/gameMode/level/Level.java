package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.SlashFX.SlashFXController;
import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.playerActions.PlayerAction;
import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.Constants;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.SlashBladeObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.slashFX.SlashFX;

import java.util.ArrayList;
import java.util.List;

public class Level implements GameMode {
    private Model model;
    private LevelObjectsContext levelObjectsContext;

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
                model.getFrameSize(), currentFPS);

        deleteObjectsFromGame();

        if (levelObjectsContext.getPlayer().getParametersContext().getHealth() <= 0) {
            return 1;
        }

        if (levelObjectsContext.getScore() >= 3) {
            return 2;
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
        levelObjectsContext.setPlayer(new SamuraiV1(Constants.PlayerConstants.ZERO_ATLAS));

        SamuraiV1 player = levelObjectsContext.getPlayer();
//        player.setImage(levelResourcesContext.getPlayerImagesResources().getOpenedResourcesList().get(0).getOpenedImage());
        player.getParametersContext().setInGameHorizontalDirection(1);
        player.setInGamePosition(model.getFrameSize().getWidth() / 2, 0);
        player.getParametersContext().setSpeedOfMoveX(700);
        player.getParametersContext().setAttackDuration(50);
        player.getParametersContext().setAttackDelay(200);
        player.getParametersContext().setRadiusForwardAttack(100);
        player.getParametersContext().setRadiusBackwardAttack(35);
        player.setObjectSize(90);
        player.setScreenLayerLevel(2);

        actionsContext.setPlayerActionController(new PlayerAction(player));
    }

    private void setBackground() {
        levelObjectsContext.setBackground(new Background(Constants.BackgroundConstants.BACKGROUND_ATLAS));
        Background bg = levelObjectsContext.getBackground();
//        bg.setImage(levelResourcesContext.getBackgroundImagesResources().getOpenedResourcesList().get(0).getOpenedImage());
        bg.setScreenLayerLevel(0);
        bg.setInGamePosition(0, -170);
        bg.setObjectSize(115);
    }

    private void setFx() {
        levelObjectsContext.setSlashFX(new SlashFX(Constants.FXConstants.SLASH_FX_ATLAS));
        levelObjectsContext.getSlashFX().setGameObjectIsExist(false);

        levelObjectsContext.getSlashFX().setObjectSize(70);
        levelObjectsContext.getSlashFX().setDrawImageOnMiddle(true);

        actionsContext.setSlashFXController(new SlashFXController(levelObjectsContext.getSlashFX()));
    }
}
