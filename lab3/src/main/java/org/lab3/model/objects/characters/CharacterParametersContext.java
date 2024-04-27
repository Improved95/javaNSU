package org.lab3.model.objects.characters;

public class CharacterParametersContext {
    protected int health = 0;
    protected double speedOfMoveX;
    protected double radiusForwardAttack;
    protected double radiusBackwardAttack;

    protected double attackDuration = 0;
    protected double attackDelay = 0;
    protected boolean attack = false;

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

    public double getRadiusForwardAttack() {
        return radiusForwardAttack;
    }

    public void setRadiusForwardAttack(double radiusForwardAttack) {
        this.radiusForwardAttack = radiusForwardAttack;
    }

    public double getRadiusBackwardAttack() {
        return radiusBackwardAttack;
    }

    public void setRadiusBackwardAttack(double radiusBackwardAttack) {
        this.radiusBackwardAttack = radiusBackwardAttack;
    }
}
