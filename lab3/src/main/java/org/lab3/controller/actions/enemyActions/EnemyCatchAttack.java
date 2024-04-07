package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.AllCharactersActionsContext;
import org.lab3.controller.gameMode.level.ObjectAndHisMovement;
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
    public void execute(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            Set<SamuraiV1> deleteEnemySet = new HashSet<>();
//            Set<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> deleteMovementSet = new HashSet<>();

            SamuraiV1 player = levelObjectsContext.getPlayer();
            if (player.getParametersContext().isAttack()) {
                double relativePos = character.getInGamePosX() - player.getInGamePosX();
                double radiusForwardAttack = player.getParametersContext().getRadiusForwardAttack();
                double radiusBackwardAttack = player.getParametersContext().getRadiusBackwardAttack();
                if (player.getParametersContext().getInGameHorizontalDirection() == 1) {
                    if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                        deleteEnemySet.add((SamuraiV1) character);

//                        actionsContext.getEnemyMovementList().indexOf();
//                        deleteMovementSet.add();
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
