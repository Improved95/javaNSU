package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

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
        /*if (enemy.isAttack()) {
            double relativePos = character.getInGamePosX() - enemy.getInGamePosX();
            double radiusForwardAttack = enemy.getRadiusForwardAttack();
            double radiusBackwardAttack = enemy.getRadiusBackwardAttack();
            if (enemy.getInGameHorizontalDirection() == 1) {
                if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                    character.setHealth(character.getHealth() - 1);
                }
            } else {
                if (relativePos >= -radiusForwardAttack && relativePos <= radiusBackwardAttack) {
                    character.setHealth(character.getHealth() - 1);
                }
            }
        }*/
        if (enemy.isAttack()) {
            /*System.out.println(character.getInGamePosX() + " " + character.getInGamePosY());

            System.out.println(character.getHitbox().x + " " + character.getHitbox().y + " " +
                    character.getHitbox().width + " " + character.getHitbox().height);

            Rectangle ph = enemy.getAttackHitbox();
            System.out.println(ph.x + " " + ph.y + " " +
                    ph.width + " " + ph.height);

            System.out.println("---");*/

            if (character.getHitbox().intersects(enemy.getAttackHitbox())) {
                character.setHealth(character.getHealth() - 1);
            }
        }
    }
}


