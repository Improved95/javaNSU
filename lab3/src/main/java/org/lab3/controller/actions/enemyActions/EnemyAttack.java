package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public class EnemyAttack extends ActionExecuteAbstract {
    private double attackDuration;
    private double attackDelay;

    public EnemyAttack(SlashBladeCharacterAbstract character) {
        this.isExecute = true;
        this.attackDuration = character.getParametersContext().getAttackDuration();
        this.attackDelay = character.getParametersContext().getAttackDelay();
    }


    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double relativePos = player.getInGamePosX() - character.getInGamePosX();
            double radiusForwardAttack = character.getParametersContext().getRadiusForwardAttack();
            if (Math.abs(relativePos) <= radiusForwardAttack) {
                attack(character, currentFPS);
            }
        }
    }

    private void attack(SamuraiV1 character, double currentFPS) {
        if (attackDuration > 0) {
            character.getParametersContext().setAttackStatus(true);
            attackDuration -= 1000 / currentFPS;
        } else {
            if (attackDelay > 0) {
                attackDelay -= 1000 / currentFPS;
                character.getParametersContext().setAttackStatus(false);
            } else {
                attackDuration = character.getParametersContext().getAttackDuration();
                attackDelay = character.getParametersContext().getAttackDelay();
            }
        }
    }
}
