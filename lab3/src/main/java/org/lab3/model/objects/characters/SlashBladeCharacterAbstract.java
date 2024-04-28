package org.lab3.model.objects.characters;

import org.lab3.model.objects.SlashBladeObjectAbstract;

import java.awt.*;

public abstract class SlashBladeCharacterAbstract extends SlashBladeObjectAbstract {
    protected int health = 0;
    protected double speedOfMoveX;
    protected Rectangle attackHitbox = new Rectangle();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeedOfMoveX() {
        return speedOfMoveX;
    }

    public void setSpeedOfMoveX(double speedOfMoveX) {
        this.speedOfMoveX = speedOfMoveX;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Rectangle getAttackHitbox() {
        return attackHitbox;
    }

    @Override
    public void setObjectSize(double screenSize) {
        double newSize = screenSize / 100;
        setWidth((int)(objectWidth * newSize));
        setHeight((int)(objectHeight * newSize));

        setScreenWidth(objectWidth);
        setScreenHeight(objectHeight);

        this.screenSize = screenSize;
    }

    @Override
    public void setWidth(int objectWidth) {
        this.objectWidth = objectWidth;
        this.hitbox.setSize(objectWidth, objectHeight);
    }

    @Override
    public void setHeight(int objectHeight) {
        this.objectHeight = objectHeight;
        this.hitbox.setSize(objectWidth, objectHeight);
    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
