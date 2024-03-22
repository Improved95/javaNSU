package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.slashBlade.JFrameObject;

import javax.swing.*;

public interface View {
    void change(Model slashBladeModel, JFrameObject jFrame) throws IllegalAccessException;
}
