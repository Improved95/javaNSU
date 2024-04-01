package org.lab3.controller.characterMovement;

public class CharacterParametersContext {
    private int health = 0;

    private int inGameHorizontalDirection;
    private double speedOfMoveX;

    private double attackDuration = 0;
    private double attackDelay = 0;
    private boolean attackStatus = false;

    public int getInGameHorizontalDirection() {
        return inGameHorizontalDirection;
    }

    public void setInGameHorizontalDirection(int direction) {
        this.inGameHorizontalDirection = direction;
    }

    public double getSpeedOfMoveX() {
        return speedOfMoveX;
    }

    public void setSpeedOfMoveX(double speedOfMoveX) {
        this.speedOfMoveX = speedOfMoveX;
    }

    public double getAttackDuration() {
        return attackDuration;
    }

    public void setAttackDuration(int attackDuration) {
        this.attackDuration = attackDuration;
    }

    public double getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }

    public boolean isAttackStatus() {
        return attackStatus;
    }

    public void setAttackStatus(boolean attackStatus) {
        this.attackStatus = attackStatus;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
