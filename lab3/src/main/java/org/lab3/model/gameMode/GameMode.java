package org.lab3.model.gameMode;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;

import java.util.Set;

public interface GameMode {
    void initial();
    void execute();
    void actionOnKeyPress(int keyCode);
    void actionOnKeyReleased(int keyCode);
    void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList);
}
