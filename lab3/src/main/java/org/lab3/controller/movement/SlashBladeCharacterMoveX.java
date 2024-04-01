package org.lab3.controller.movement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterMoveX extends SlashBladeCharacterMovementAbstract {

    public SlashBladeCharacterMoveX(SlashBladeCharacterAbstract character) {
        super(character);
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        if (isExecute && !blockExecute) {
            character.moveX(currentFPS, frameSize);
        }
    }
}
