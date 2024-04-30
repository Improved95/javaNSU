package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

public class PlayerCatchAttack extends ActionExecuteAbstract {
    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext) {
        if (isExecute && !isBlockExecute) {
            for (SamuraiV1 enemy : levelObjectsContext.getEnemyList()) {
                catchEnemyAttack(character, enemy);
            }
        }
    }

    private void catchEnemyAttack(SamuraiV1 character, SamuraiV1 enemy) {
        if (enemy.isAttack()) {
            if (character.getHitbox().intersects(enemy.getAttackHitbox())) {
                character.setHealth(character.getHealth() - 1);
            }
        }
    }
}


