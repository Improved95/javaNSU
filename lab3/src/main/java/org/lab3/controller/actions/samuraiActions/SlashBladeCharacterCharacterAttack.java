package org.lab3.controller.actions.samuraiActions;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterCharacterAttack extends SlashBladeCharacterActionControllerAbstract {
    private double attackDuration;
    private double attackDelay;

    public SlashBladeCharacterCharacterAttack(SlashBladeCharacterAbstract character) {
        super(character);
        this.attackDuration = character.getParametersContext().getAttackDuration();
        this.attackDelay = character.getParametersContext().getAttackDelay();
    }

    @Override
    public void attack() {
        isExecute = true;
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
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
}
