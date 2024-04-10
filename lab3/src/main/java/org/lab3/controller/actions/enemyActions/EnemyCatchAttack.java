package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class EnemyCatchAttack extends EnemyActionAbstract {

    public EnemyCatchAttack(SlashBladeCharacterAbstract character) {
        super(character);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext, double currentFPS, FrameSize frameSize) {
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
