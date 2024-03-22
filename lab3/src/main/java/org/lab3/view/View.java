package org.lab3.view;

import org.lab3.model.Model;

import javax.swing.*;

public interface View {
    void change(Model slashBladeModel, JFrame jFrame, int screenHeight) throws IllegalAccessException;
}
