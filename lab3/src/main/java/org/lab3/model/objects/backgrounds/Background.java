package org.lab3.model.objects.backgrounds;

import org.lab3.model.annotations.DrawObject;
import org.lab3.model.objects.SlashBladeAbstractObject;

@DrawObject
public class Background extends SlashBladeAbstractObject {
    public Background() {
        setInGamePosition(0, 0);
        setScreenSize(100);
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
