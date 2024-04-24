package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

public class PlayerAction implements ActionController {
    private static SamuraiV1 character;

    private static PlayerCatchAttack playerCatchAttack = new PlayerCatchAttack();
    private static PlayerMoveX playerMoveX = new PlayerMoveX();
    private static PlayerAttack playerAttack = new PlayerAttack(character);

    public PlayerAction(SamuraiV1 character) {
        this.character = character;
    }

    public static PlayerCatchAttack getPlayerCatchAttack() {
        return playerCatchAttack;
    }

    public static PlayerMoveX getPlayerMoveX() {
        return playerMoveX;
    }

    public static PlayerAttack getPlayerAttack() {
        return playerAttack;
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, FrameSize frameSize) {

        playerAttack.execute(character, currentFPS);
        playerCatchAttack.execute(character, levelObjectsContext);
        playerMoveX.execute(character, currentFPS, frameSize);
    }
}
