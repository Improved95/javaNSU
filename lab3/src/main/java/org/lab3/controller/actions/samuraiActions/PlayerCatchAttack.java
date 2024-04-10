package org.lab3.controller.actions.samuraiActions;

import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class PlayerCatchAttack extends PlayerActionAbstract {

    public PlayerCatchAttack(SlashBladeCharacterAbstract character) {
        super(character);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            for (SamuraiV1 enemy : levelObjectsContext.getEnemyList()) {
                catchEnemyAttack(enemy, levelObjectsContext);
            }
        }
    }

    private void catchEnemyAttack(SamuraiV1 enemy, LevelObjectsContext levelObjectsContext) {
        if (enemy.getParametersContext().isAttack()) {
            double relativePos = character.getInGamePosX() - enemy.getInGamePosX();
            double radiusForwardAttack = enemy.getParametersContext().getRadiusForwardAttack();
            double radiusBackwardAttack = enemy.getParametersContext().getRadiusBackwardAttack();
            if (enemy.getParametersContext().getInGameHorizontalDirection() == 1) {
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


