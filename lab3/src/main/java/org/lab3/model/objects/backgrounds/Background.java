package org.lab3.model.objects.backgrounds;

import org.lab3.model.annotations.DrawObject;
import org.lab3.model.objects.SlashBladeAbstractObject;

@DrawObject
public class Background extends SlashBladeAbstractObject {
    public Background() {
        setInGamePosition(-400, -170);
        setScreenSize(115);
    }

    @Override
    public int getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public int getScreenPosY() {
        return inGamePosY;
    }
}
