package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

public class EnemyAttack extends ActionExecuteAbstract {
    private double attackDuration;
    private double attackDelay;

    public EnemyAttack(SamuraiV1 character) {
        this.attackDuration = character.getAttackDuration();
        this.attackDelay = character.getAttackDelay();
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS) {
        if (isExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double relativePos = player.getInGamePosX() - character.getInGamePosX();
            double radiusForwardAttack = character.getRadiusForwardAttack();
            if (Math.abs(relativePos) <= radiusForwardAttack) {
                attack(character, currentFPS);
            }
        }
    }

    private void attack(SamuraiV1 character, double currentFPS) {
        if (attackDuration > 0) {
            if (!isBlockExecute) {
                character.setAttack(true);
                character.getSlashFX().setGameObjectIsExist(true);
                attackDuration -= 1000 / currentFPS;
            }
        } else {
            if (attackDelay > 0) {
                attackDelay -= 1000 / currentFPS;
                character.setAttack(false);
                character.getSlashFX().setGameObjectIsExist(false);
            } else {
                attackDuration = character.getAttackDuration();
                attackDelay = character.getAttackDelay();
            }
        }
    }
}
