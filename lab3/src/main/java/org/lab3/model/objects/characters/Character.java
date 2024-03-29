package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;
import org.lab3.slashBlade.FrameSize;

public abstract class Character extends SlashBladeAbstractObject implements SlashBladeCharacter {
    protected int direction;
    protected double speedOfRun; // units per second
    protected boolean isMoveX;

    public Character() {
        setDrawImageOnMiddle(true);
    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }

    @Override
    public void changeMoveXStatus(boolean isRun) {
        this.isMoveX = isRun;
    }

    @Override
    public void changeDirection(int direction) {
        this.direction = direction;
        setHorizontalDirection(direction);
    }

    @Override
    public void moveX(double currentFPS, FrameSize frameSize) {
        if (isMoveX) {
            inGamePosX += getValueByFPS((speedOfRun * this.direction * frameSize.getReductionFactor()) , currentFPS);
        }
    }

    protected double getValueByFPS(double value, double FPS) {
        return value / FPS;
    }
}
