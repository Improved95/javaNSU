package org.lab3.model.gameMode;

import org.lab3.model.NeedDrawObject;

import java.util.Set;

public interface GameMode {
    void execute();
    Set<NeedDrawObject> getDrawObjectsList() throws IllegalAccessException;
}
