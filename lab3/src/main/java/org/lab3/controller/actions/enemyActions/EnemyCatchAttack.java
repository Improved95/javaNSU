package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

import java.awt.*;

public class EnemyCatchAttack extends ActionExecuteAbstract {

    public EnemyCatchAttack() {
        this.isExecute = true;
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            /*if (player.isAttack()) {
                double relativePos = character.getInGamePosX() - player.getInGamePosX();
                double radiusForwardAttack = player.getRadiusForwardAttack();
                double radiusBackwardAttack = player.getRadiusBackwardAttack();
                if (player.getInGameHorizontalDirection() == 1) {
                    if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                        character.setHealth(character.getHealth() - 1);
                    }
                } else {
                    if (relativePos >= -radiusForwardAttack && relativePos <= radiusBackwardAttack) {
                        character.setHealth(character.getHealth() - 1);
                    }
                }
            }*/
            if (player.isAttack()) {
                if (character.getHitbox().intersects(player.getAttackHitbox())) {
                    character.setHealth(character.getHealth() - 1);
                }
            }
        }
    }
}
