package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeAbstractObject;
import org.lab3.controller.movement.CharacterMovement;
import org.lab3.controller.movement.CharacterParametersContext;
import org.lab3.slashBlade.FrameSize;

import java.util.HashMap;
import java.util.Map;

public abstract class SlashBladeCharacterAbstract extends SlashBladeAbstractObject implements SlashBladeCharacter {
    protected CharacterParametersContext parametersContext = new CharacterParametersContext();
    protected Map<String, CharacterMovement> movementList = new HashMap<>();

    public SlashBladeCharacterAbstract() {
        setDrawImageOnMiddle(true);
    }

    @Override
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
    public Map<String, CharacterMovement> getMovementList() {
        return movementList;
    }

    @Override
    public void changeDirection(int direction) {
        parametersContext.setDirection(direction);
        setHorizontalDirection(direction);
    }

    @Override
    public void moveX(double currentFPS, FrameSize frameSize) {
        inGamePosX += getValueByFPS((parametersContext.getSpeedOfMoveX() * parametersContext.getDirection() * frameSize.getReductionFactor()) , currentFPS);
    }

    @Override
    public void attack() {}

    protected double getValueByFPS(double value, double FPS) {
        return value / FPS;
    }
}
