package org.lab3.controller.gameMode;


public interface GameMode {
    void initial();

    int execute(double currentFPS);

    void actionOnKeyPressed(int keyCode);

    void actionOnKeyReleased(int keyCode);

    void actionOnMousePressed(int mouseKeyCode, int posX, int posY);

    void reset();
}
