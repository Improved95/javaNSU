package org.lab3.model.objects.characters;

public class CharacterParametersContext {
    private int health = 0;
    private int inGameHorizontalDirection;
    private double speedOfMoveX;

    private double attackDuration = 0;
    private double attackDelay = 0;
    private boolean attack = false;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getInGameHorizontalDirection() {
        return inGameHorizontalDirection;
    }

    public void setInGameHorizontalDirection(int inGameHorizontalDirection) {
        this.inGameHorizontalDirection = inGameHorizontalDirection;
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

    public void setAttackDuration(double attackDuration) {
        this.attackDuration = attackDuration;
    }

    public double getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(double attackDelay) {
        this.attackDelay = attackDelay;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttackStatus(boolean attack) {
        this.attack = attack;
    }
}
