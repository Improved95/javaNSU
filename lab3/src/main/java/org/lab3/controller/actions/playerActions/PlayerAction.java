package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.characters.SamuraiV1;

public class PlayerAction implements ActionController {
    private SamuraiV1 character;

    private PlayerCatchAttack playerCatchAttack;
    private PlayerMoveX playerMoveX;
    private PlayerAttack playerAttack;

    public PlayerAction(SamuraiV1 character) {
        this.character = character;
        playerMoveX = new PlayerMoveX();
        playerAttack = new PlayerAttack(character);
        playerCatchAttack = new PlayerCatchAttack();
    }

    public SamuraiV1 getCharacter() {
        return character;
    }

    public PlayerCatchAttack getPlayerCatchAttack() {
        return playerCatchAttack;
    }

    public PlayerMoveX getPlayerMoveX() {
        return playerMoveX;
    }

    public PlayerAttack getPlayerAttack() {
        return playerAttack;
    }

    public void changeMoveX(int a, int d) {
        playerMoveX.changeMoveX(character, a, d);
    }

    public void attack() {
        playerAttack.initialAttack();
    }

    public void initial() {
        playerMoveX.initial();
        playerAttack.initial(character);
        playerCatchAttack.initial();
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, Model model) {

        playerAttack.execute(character, levelObjectsContext, currentFPS);
        playerCatchAttack.execute(character, levelObjectsContext);
        playerMoveX.execute(character, currentFPS, model.getFrameSize());

        character.changeInGamePos(character.getCurrentSpeedX(), character.getCurrentSpeedY());
    }
}
