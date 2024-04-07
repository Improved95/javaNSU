package org.lab3.controller.actions.enemyActions;

import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

import java.util.HashSet;
import java.util.Set;

public class EnemyCatchAttack extends EnemyActionAbstract {

    public EnemyCatchAttack(SlashBladeCharacterAbstract character) {
        super(character);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            Set<SamuraiV1> deleteEnemySet = new HashSet<>();

            SamuraiV1 player = levelObjectsContext.getPlayer();
            if (player.getParametersContext().isAttack()) {
                double relativePos = character.getInGamePosX() - player.getInGamePosX();
                double radiusForwardAttack = player.getParametersContext().getRadiusForwardAttack();
                double radiusBackwardAttack = player.getParametersContext().getRadiusBackwardAttack();
                if (player.getParametersContext().getInGameHorizontalDirection() == 1) {
                    if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                        deleteEnemySet.add((SamuraiV1) character);
                    }
                } else {
                    if (relativePos >= -radiusForwardAttack && relativePos <= radiusBackwardAttack) {
                        deleteEnemySet.add((SamuraiV1) character);
                    }
                }
            }

            levelObjectsContext.getEnemyList().removeAll(deleteEnemySet);
        }
    }
}
