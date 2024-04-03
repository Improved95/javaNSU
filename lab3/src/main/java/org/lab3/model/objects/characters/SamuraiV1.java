package org.lab3.model.objects.characters;

public class SamuraiV1 extends SlashBladeCharacterAbstract {
    public SamuraiV1() {
        parametersContext.setInGameHorizontalDirection(1);
        parametersContext.setSpeedOfMoveX(700);
        parametersContext.setAttackDuration(50);
        parametersContext.setAttackDelay(200);
        parametersContext.setRadiusForwardAttack(110);
        parametersContext.setRadiusBackwardAttack(35);
        parametersContext.setHealth(1);
        setScreenSize(90);
    }
}
