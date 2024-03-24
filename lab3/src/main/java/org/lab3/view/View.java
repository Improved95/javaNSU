package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.slashBlade.JFrameObject;

public interface View {
    void change(Model slashBladeModel, JFrameObject jFrameObject) throws IllegalAccessException;
}
