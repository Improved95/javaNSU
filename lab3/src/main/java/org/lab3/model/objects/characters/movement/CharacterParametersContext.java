package org.lab3.model.objects.characters.movement;

public class CharacterParametersContext {
    private int direction;
    private double speedOfMoveX; // units per second

    private int attackDuration = 0; //ms
    private int attackDelay = 0; //ms
    private boolean attackStatus = false;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeedOfMoveX() {
        return speedOfMoveX;
    }

    public void setSpeedOfMoveX(double speedOfMoveX) {
        this.speedOfMoveX = speedOfMoveX;
    }

    public int getAttackDuration() {
        return attackDuration;
    }

    public void setAttackDuration(int attackDuration) {
        this.attackDuration = attackDuration;
    }

    public int getAttackDelay() {
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
}
