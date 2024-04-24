package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

public class EnemyCatchAttack extends ActionExecuteAbstract {

    public EnemyCatchAttack() {
        this.isExecute = true;
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            if (player.getParametersContext().isAttack()) {
                double relativePos = character.getInGamePosX() - player.getInGamePosX();
                double radiusForwardAttack = player.getParametersContext().getRadiusForwardAttack();
                double radiusBackwardAttack = player.getParametersContext().getRadiusBackwardAttack();
                if (player.getParametersContext().getInGameHorizontalDirection() == 1) {
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
}
