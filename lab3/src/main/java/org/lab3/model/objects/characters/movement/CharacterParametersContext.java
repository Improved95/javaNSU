package org.lab3.model.objects.characters.movement;

public class CharacterParametersContext {
    private int direction;
    private double speedOfMoveX; // units per second

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
}
