package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

public class EnemyCatchAttack extends ActionExecuteAbstract {
    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            if (player.isAttack()) {
                if (character.getHitbox().intersects(player.getAttackHitbox())) {
                    character.setHealth(character.getHealth() - 1);
                }
            }
        }
    }
}
