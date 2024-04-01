package org.lab3.controller.characterMovement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterAttack extends SlashBladeCharacterMovementAbstract {
    private double attackDuration; //ms
    private double attackDelay; //ms

    /*public SlashBladeCharacterAttack(SlashBladeCharacterAbstract character, double attackDuration, double attackDelay) {
        super(character);
        this.attackDuration = attackDuration;
        this.attackDelay = attackDelay;
    }*/

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        /*character.getParametersContext().setAttackStatus(true);
        if (isExecute && !blockExecute) {
            if (attackDuration > 0) {
                attackDuration -= 1000 / currentFPS;
            } else {
                character.getParametersContext().setAttackStatus(false);
                if (attackDelay > 0) {
                    attackDelay -= 1000 / currentFPS;
                } else {
                    isExecute = false;
                    attackDuration = character.getParametersContext().getAttackDuration();
                    attackDelay = character.getParametersContext().getAttackDelay();
                }
            }
        }*/
    }
}
