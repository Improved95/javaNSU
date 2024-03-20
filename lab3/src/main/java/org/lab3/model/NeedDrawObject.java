package org.lab3.model;

public interface NeedDrawObject {
    int getPosX();
    int getPosY();
    int getSize();
    void setVisualContext(VisualContext visualContext);
    VisualContext getVisualContext();
}
