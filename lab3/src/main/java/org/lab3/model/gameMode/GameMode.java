package org.lab3.model.gameMode;

import org.lab3.model.NeedDrawObject;
import org.lab3.slashBlade.FrameSize;

import java.util.Set;

public interface GameMode {
    void initial();
    void execute(double currentFPS, FrameSize frameSize);
    void actionOnKeyPress(int keyCode);
    void actionOnKeyReleased(int keyCode);
    void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList);
}
