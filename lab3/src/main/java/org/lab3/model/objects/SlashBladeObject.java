package org.lab3.model.objects;

import org.lab3.model.NeedDrawObject;

public interface SlashBladeObject extends NeedDrawObject {
    void setPosition(int x, int y);
    void changePosition(int x, int y);
    void setSize(int size);
    void changeSize(int size);
}
