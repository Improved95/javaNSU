package org.lab3.model.objects.characters;

import org.lab3.slashBlade.Constants;
import org.lab3.model.objects.slashFX.SlashFX;

public class SamuraiV1 extends SlashBladeCharacterAbstract {
    private double radiusForwardAttack;
    private double radiusBackwardAttack;
    private double attackHeight;
    private double attackDuration = 0;
    private double attackDelay = 0;
    private boolean attack = false;
    private SlashFX slashFX;

    public SamuraiV1() {
        setHealth(1);
        setScreenLayerLevel(1);
        setWidth(Constants.PlayerConstants.PLAYER_WIDTH);
        setHeight(Constants.PlayerConstants.PLAYER_HEIGHT);
        setObjectSize(100);
        setResourcesIndexInResourcesList(Constants.PlayerConstants.PLAYER_ATLAS_INDEX);
        setCurrentImageIndex(0, 0);
    }

    @Override
    public void changeDirection(int direction) {
        setInGameHorizontalDirection(direction);
        setScreenHorizontalDirection(direction);

        if (direction == 1) {
            this.attackHitbox.setLocation((int)(inGamePosX - radiusBackwardAttack), (int)(inGamePosY + objectHeight / 2 - attackHeight / 2));
        } else {
            this.attackHitbox.setLocation((int)(inGamePosX - radiusForwardAttack), (int)(inGamePosY + objectHeight / 2 - attackHeight / 2));
        }
    }

    @Override
    public void setInGamePosition(double x, double y) {
        this.inGamePosX = x;
        this.inGamePosY = y;
        this.hitbox.setLocation((int)x, (int)y);

        if (getInGameHorizontalDirection() == 1) {
            this.attackHitbox.setLocation((int)(x - radiusBackwardAttack), (int)(y + objectHeight / 2 - attackHeight / 2));
        } else {
            this.attackHitbox.setLocation((int)(x - radiusForwardAttack), (int)(y + objectHeight / 2 - attackHeight / 2));
        }
    }

    @Override
    public void changeInGamePosition(double dx, double dy) {
        this.inGamePosX += dx;
        this.inGamePosY += dy;
        this.hitbox.setLocation((int)(hitbox.getX() + dx), (int)(hitbox.getY() + dy));
        this.attackHitbox.setLocation((int)(attackHitbox.getX() + dx), (int)(attackHitbox.getY() + dy));
    }

    public double getRadiusForwardAttack() {
        return radiusForwardAttack;
    }

    public void setRadiusForwardAttack(double radiusForwardAttack) {
        this.radiusForwardAttack = radiusForwardAttack;
        this.attackHitbox.setSize((int)(radiusForwardAttack + radiusBackwardAttack + objectWidth), (int)attackHeight);
    }

    public double getRadiusBackwardAttack() {
        return radiusBackwardAttack;
    }

    public void setRadiusBackwardAttack(double radiusBackwardAttack) {
        this.radiusBackwardAttack = radiusBackwardAttack;
        this.attackHitbox.setSize((int)(radiusForwardAttack + radiusBackwardAttack + objectWidth), (int)attackHeight);
    }

    public double getAttackHeight() {
        return attackHeight;
    }

    public void setAttackHeight(double attackHeight) {
        this.attackHeight = attackHeight;
        this.attackHitbox.setSize((int)(radiusForwardAttack + radiusBackwardAttack + objectWidth), (int)attackHeight);
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

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public SlashFX getSlashFX() {
        return slashFX;
    }

    public void setSlashFX(SlashFX slashFX) {
        this.slashFX = slashFX;
    }
}
