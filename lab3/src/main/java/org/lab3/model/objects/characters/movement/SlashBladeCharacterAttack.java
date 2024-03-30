package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterAttack extends SlashBladeCharacterMovementAbstract {
    private int attackDuration; //ms
    private int attackDelay; //ms

    public SlashBladeCharacterAttack(SlashBladeCharacterAbstract character, int attackDuration, int attackDelay) {
        super(character);
        this.attackDuration = attackDuration;
        this.attackDelay = attackDelay;
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
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
        }
    }
}
