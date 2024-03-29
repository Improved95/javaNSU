package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;
import org.lab3.model.objects.characters.movement.CharacterMovement;
import org.lab3.model.objects.characters.movement.CharacterParametersContext;
import org.lab3.slashBlade.FrameSize;

import java.util.HashMap;
import java.util.Map;

public abstract class Character extends SlashBladeAbstractObject implements SlashBladeCharacter {
    protected CharacterParametersContext parametersContext = new CharacterParametersContext();
    protected Map<String, CharacterMovement> movementList = new HashMap<>();

    protected boolean isMoveX;

    public Character() {
        setDrawImageOnMiddle(true);
    }

    public CharacterParametersContext getParametersContext() {
        return parametersContext;
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
        parametersContext.setDirection(direction);
        setHorizontalDirection(direction);
    }

    @Override
    public void moveX(double currentFPS, FrameSize frameSize) {
        if (isMoveX) {
            inGamePosX += getValueByFPS((parametersContext.getSpeedOfMoveX() * parametersContext.getDirection() * frameSize.getReductionFactor()) , currentFPS);
        }
    }

    @Override
    public void attack() {

    }

    protected double getValueByFPS(double value, double FPS) {
        return value / FPS;
    }
}
