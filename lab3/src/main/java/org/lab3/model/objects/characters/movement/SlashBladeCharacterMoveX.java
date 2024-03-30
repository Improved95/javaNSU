package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.SlashBladeCharacter;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterMoveX extends SlashBladeCharacterMovementAbstract {
    @Override
    public void execute(SlashBladeCharacter character, movementParametersContext,
                            double currentFPS, FrameSize frameSize) {

        if (isExecute) {

            character.moveX(currentFPS, frameSize);
        }
    }
}
