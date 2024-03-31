package org.lab3.model.gameMode;

import org.lab3.slashBlade.FrameSize;
import org.lab3.view.LinkedSetDrawObjects;


public interface GameMode {
    void initial();
    void execute(double currentFPS, FrameSize frameSize);
    void actionOnKeyPress(int keyCode);
    void actionOnKeyReleased(int keyCode);
    void actionOnMousePressed(int mouseKeyCode);
    void getDrawObjectsList(LinkedSetDrawObjects drawObjectsList);
}
