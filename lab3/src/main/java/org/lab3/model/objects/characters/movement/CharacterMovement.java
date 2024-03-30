package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.SlashBladeCharacter;
import org.lab3.slashBlade.FrameSize;

public interface CharacterMovement {
    void changeExecuteStatus(boolean execute);
    void execute(SlashBladeCharacter character, double currentFPS, FrameSize frameSize);
}
