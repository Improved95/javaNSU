package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterMoveX extends SlashBladeCharacterMovementAbstract {
    private CharacterParametersContext characterParametersContext;

    public SlashBladeCharacterMoveX(SlashBladeCharacterAbstract character) {
        super(character);
        character.getParametersContext();
    }

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        if (isExecute) {
            character.moveX(currentFPS, frameSize);
        }
    }
}
