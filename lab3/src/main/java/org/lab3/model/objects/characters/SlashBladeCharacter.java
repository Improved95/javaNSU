package org.lab3.model.objects.characters;

import org.lab3.slashBlade.FrameSize;

public interface SlashBladeCharacter {
    void changeDirection(int direction);
    void changeMoveXStatus(boolean isMoveX);
    void moveX(double currentFPS, FrameSize frameSize);
}
