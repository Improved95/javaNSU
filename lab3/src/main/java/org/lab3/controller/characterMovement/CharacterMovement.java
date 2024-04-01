package org.lab3.controller.characterMovement;

import org.lab3.slashBlade.FrameSize;

public interface CharacterMovement {
    void changeExecuteStatus(boolean execute);
    void execute(double currentFPS, FrameSize frameSize);
}
