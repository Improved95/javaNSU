package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.SlashFX.SlashFXAction;
import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.pause.PauseAction;
import org.lab3.controller.actions.playerActions.PlayerAction;
import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.Constants;
import org.lab3.model.objects.SlashBladeObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.pause.Pause;
import org.lab3.model.objects.slashFX.SlashFX;

import java.util.ArrayList;
import java.util.List;

public class Level implements GameMode {
    private Model model;
    private LevelObjectsContext levelObjectsContext;
    private EnemyCreator enemyCreator = new EnemyCreator();
    private AllCharactersActionsContext actionsContext;
    private boolean isPause;

    private Level(Model model) {
        this.model = model;
        initial();
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
                break;
            case 27:
                putOnPause();
                break;
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
    public void actionOnMousePressed(int mouseKeyCode, int posX, int posY) {
        if (!isPause) {
            if (mouseKeyCode == 1) {
                actionsContext.getPlayerActionController().attack();
            }
        } else {
            if (mouseKeyCode == 1) {
                actionsContext.getPauseAction().mousePressed(posX, posY);
            }
        }
    }

    @Override
    public int execute(double currentFPS) {
        if (!isPause) {
            return mainActionInLevel(currentFPS);
        } else {
            int returnValue = pauseActionsInLevel(currentFPS);
            switch (returnValue) {
                case Constants.GameConstants.REMOVE_FROM_PAUSE -> {
                    removeFromPause();
                }
                case Constants.GameConstants.RESET -> {
                    reset();
                    removeFromPause();
                }
                case Constants.GameConstants.EXIT_GAME -> {
                    return Constants.GameConstants.EXIT_GAME;
                }
            }
            return Constants.GameConstants.NOTHING_DOING;
        }
    }

    private int mainActionInLevel(double currentFPS) {
        actionsContext.getPlayerActionController().nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        actionsContext.getSlashFXController().nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        for (EnemyAction enemyActionController : actionsContext.getEnemyActionsControllers()) {
            enemyActionController.nextTick(levelObjectsContext, actionsContext, currentFPS, model);
        }

        enemyCreator.create(levelObjectsContext.getEnemyList(), actionsContext,
                model.getFrameSize(), currentFPS);

        deleteObjectsFromGame();

        if (levelObjectsContext.getPlayer().getHealth() <= 0) {
            return Constants.GameConstants.EXIT_GAME;
        }

        if (levelObjectsContext.getScore() >= 3) {
            return Constants.GameConstants.EXIT_GAME;
        }

        return 0;
    }

    private int pauseActionsInLevel(double currentFPS) {
        return actionsContext.getPauseAction().nextTick(levelObjectsContext, actionsContext, currentFPS, model);
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

    private void putOnPause() {
        levelObjectsContext.getLevelPause().setGameObjectIsExist(true);
        isPause = true;
    }

    private void removeFromPause() {
        levelObjectsContext.getLevelPause().setGameObjectIsExist(false);
        actionsContext.getPauseAction().initial();
        isPause = false;
    }

    @Override
    public void initial() {
        this.levelObjectsContext = new LevelObjectsContext();
        this.model.setGameModeObjectsContext(levelObjectsContext);
        this.actionsContext = new AllCharactersActionsContext();
        setPlayer();
        setPlayerZeroState();

        setBackground();
        setBackgroundZeroState();

        setFx();
        setFxZeroState();

        setPauseLayout();
        setPauseLayoutZeroState();

        actionsContext.setEnemyActionsControllers(new ArrayList<>());
        enemyCreator.setCreateDelay(2000);
    }

    @Override
    public void reset() {
        setPlayerZeroState();
        setBackgroundZeroState();
        setFxZeroState();
        setPauseLayoutZeroState();
        isPause = false;
        levelObjectsContext.getEnemyList().clear();
        actionsContext.getEnemyActionsControllers().clear();
    }

    private void setPlayer() {
        SamuraiV1 player = new SamuraiV1();
        player.setObjectSize(90);
        levelObjectsContext.setPlayer(player);
        actionsContext.setPlayerActionController(new PlayerAction(player));
    }

    private void setPlayerZeroState() {
        SamuraiV1 player = levelObjectsContext.getPlayer();
        player.setInGameHorizontalDirection(1);
        player.setInGamePosition(model.getFrameSize().getWidth() / 2, 0);
        player.setSpeedOfMoveX(700);
        player.setAttackDuration(50);
        player.setAttackDelay(200);
        player.setRadiusForwardAttack(100);
        player.setRadiusBackwardAttack(35);
        player.setAttackHeight(30);
        player.setObjectSize(100);
        player.setScreenLayerLevel(2);
    }

    private void setBackground() {
        Background bg = new Background();
        bg.setObjectSize(115);
        levelObjectsContext.setBackground(bg);
    }

    private void setBackgroundZeroState() {
        Background bg = levelObjectsContext.getBackground();
        bg.setScreenLayerLevel(0);
        bg.setInGamePosition(0, -170);
    }

    private void setFx() {
        SlashFX slashFX = new SlashFX();
        slashFX.setObjectSize(70);
        levelObjectsContext.setSlashFX(slashFX);
        actionsContext.setSlashFXController(new SlashFXAction(slashFX));
    }

    private void setFxZeroState() {
        SlashFX slashFX = levelObjectsContext.getSlashFX();
        slashFX.setGameObjectIsExist(false);
        actionsContext.getSlashFXController().initial();
    }

    private void setPauseLayout() {
        levelObjectsContext.setLevelPause(new Pause(model.getFrameSize()));
        actionsContext.setPauseAction(new PauseAction(levelObjectsContext.getLevelPause()));
    }

    private void setPauseLayoutZeroState() {
        Pause pause = levelObjectsContext.getLevelPause();
        pause.setGameObjectIsExist(false);
    }
}
