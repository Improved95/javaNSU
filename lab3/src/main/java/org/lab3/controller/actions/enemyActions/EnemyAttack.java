package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class EnemyAttack extends EnemyActionAbstract {
    private double attackDuration;
    private double attackDelay;

    public EnemyAttack(SlashBladeCharacterAbstract character) {
        super(character);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double playerPosX = player.getInGamePosX();


        }
    }

    private void attack(double currentFPS) {
        if (attackDuration > 0) {
            character.getParametersContext().setAttackStatus(true);
            attackDuration -= 1000 / currentFPS;
        } else {
            if (attackDelay > 0) {
                attackDelay -= 1000 / currentFPS;
                character.getParametersContext().setAttackStatus(false);
            } else {
                isExecute = false;
                attackDuration = character.getParametersContext().getAttackDuration();
                attackDelay = character.getParametersContext().getAttackDelay();
            }
        }
    }
}
