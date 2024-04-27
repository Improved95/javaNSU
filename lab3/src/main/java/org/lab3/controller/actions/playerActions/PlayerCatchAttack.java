package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class PlayerCatchAttack extends ActionExecuteAbstract {

    public PlayerCatchAttack() {
        this.isExecute = true;
    }

    public void initial() {

    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext) {
        if (isExecute && !isBlockExecute) {
            for (SamuraiV1 enemy : levelObjectsContext.getEnemyList()) {
                catchEnemyAttack(character, enemy);
            }
        }
    }

    private void catchEnemyAttack(SamuraiV1 character, SamuraiV1 enemy) {
        if (enemy.getParametersContext().isAttack()) {
            double relativePos = character.getInGamePosX() - enemy.getInGamePosX();
            double radiusForwardAttack = enemy.getParametersContext().getRadiusForwardAttack();
            double radiusBackwardAttack = enemy.getParametersContext().getRadiusBackwardAttack();
            if (enemy.getInGameHorizontalDirection() == 1) {
                if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                    character.getParametersContext().setHealth(character.getParametersContext().getHealth() - 1);
                }
            } else {
                if (relativePos >= -radiusForwardAttack && relativePos <= radiusBackwardAttack) {
                    character.getParametersContext().setHealth(character.getParametersContext().getHealth() - 1);
                }
            }
        }
    }
}


