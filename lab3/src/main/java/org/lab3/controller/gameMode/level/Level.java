package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.actions.enemyActions.EnemyActionAbstract;
import org.lab3.controller.actions.samuraiActions.PlayerActionAbstract;
import org.lab3.controller.actions.samuraiActions.PlayerAttack;
import org.lab3.controller.actions.samuraiActions.PlayerMove;
import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.resources.ResourcesContext;
import org.lab3.slashBlade.FrameSize;
import org.lab3.slashBlade.JFrameObject;

import java.util.HashMap;
import java.util.Map;

public class Level implements GameMode {
    private Model model;
    private LevelObjectsContext levelObjectsContext = new LevelObjectsContext();
    private JFrameObject jFrameObject;

    private ResourcesContext samuraiImagesResources;
    private ResourcesContext backgroundImagesResources;
    private ResourcesContext enemyImagesResources;

    private EnemyCreator enemyCreator = new EnemyCreator();

    private Map<String, PlayerActionAbstract> playerMovementList = new HashMap<>();
    private Map<String, EnemyActionAbstract> enemyMovementList = new HashMap<>();

    private Level(Model model, JFrameObject jFrameObject) {
        this.model = model;
        this.model.setGameModeObjectsContext(levelObjectsContext);
        this.jFrameObject = jFrameObject;
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

        fillPlayerMovementList();

        setPlayer(levelObjectsContext.getPlayer());
        setBackground(levelObjectsContext.getBackground());
        enemyCreator.setCreateDelay(1000);
    }

    @Override
    public void actionOnKeyPressed(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                playerMovementList.get("PLAYER_MOVE_X").changeMoveX(1, -1);
                break;
            case 83:
                break;
            case 68:
                playerMovementList.get("PLAYER_MOVE_X").changeMoveX(-1, 1);
        }
    }

    @Override
    public void actionOnKeyReleased(int keyCode) {
        switch (keyCode) {
            case 87:
                break;
            case 65:
                playerMovementList.get("PLAYER_MOVE_X").changeMoveX(0, -1);
                break;
            case 83:
                break;
            case 68:
                playerMovementList.get("PLAYER_MOVE_X").changeMoveX(-1, 0);
                break;
        }
    }

    @Override
    public void actionOnMousePressed(int mouseKeyCode) {
        if (mouseKeyCode == 1) {
            playerMovementList.get("PLAYER_ATTACK").attack();
        }
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        playerAction(currentFPS, frameSize);

        SamuraiV1 enemy = enemyCreator.create(levelObjectsContext.getEnemyList(), enemyImagesResources, jFrameObject.getFrameSize(), currentFPS);


    }

    private void playerAction(double currentFPS, FrameSize frameSize) {
        playerMovementList.get("PLAYER_MOVE_X").execute(currentFPS, frameSize);
        playerMovementList.get("PLAYER_ATTACK").execute(currentFPS, frameSize);
    }

    private void setPlayer(SlashBladeCharacterAbstract slashBladeCharacter) {
        slashBladeCharacter.setScreenLayerLevel(1);
        slashBladeCharacter.getParametersContext().setHealth(3);
        slashBladeCharacter.setInGamePosition(jFrameObject.getFrameSize().getWidth() / 2, 0);
        slashBladeCharacter.setScreenSize(90);
    }

    private void setBackground(SlashBladeObjectAbstract slashBladeObject) {
        slashBladeObject.setScreenLayerLevel(0);
        slashBladeObject.setInGamePosition(0, -170);
        slashBladeObject.setScreenSize(115);
    }

    private void fillPlayerMovementList() {
        playerMovementList.put("PLAYER_MOVE_X", new PlayerMove(levelObjectsContext.getPlayer()));
        playerMovementList.put("PLAYER_ATTACK", new PlayerAttack(levelObjectsContext.getPlayer()));
//        characterMovementList.put("ENEMY_MOVE", new SlashBladeEnemyMove());
    }
}
