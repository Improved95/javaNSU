package org.lab3.model.gameMode;

import org.lab3.model.NeedDrawObject;

import java.util.AbstractList;

public interface GameMode {
    void execute();
    AbstractList<NeedDrawObject> getNeedDrawObject();
}
