package org.lab3.model.Debug;

import org.lab3.model.objects.SlashBladeObjectAbstract;

import java.awt.*;

public class DebugObject extends SlashBladeObjectAbstract {
    Rectangle rectangle;

    public DebugObject(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
