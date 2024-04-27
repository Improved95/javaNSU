package org.lab3.model.objects.slashFX;

import org.lab3.view.Constants;
import org.lab3.model.objects.SlashBladeObjectAbstract;

public class SlashFX extends SlashBladeObjectAbstract {
    public SlashFX(String atlas) {
        super(atlas);

        setWidth(Constants.FXConstants.SLASH_FX_WIDTH);
        setHeight(Constants.FXConstants.SLASH_FX_HEIGHT);
        setResourcesIndexInResourcesList(Constants.FXConstants.SLASH_FX_ATLAS_INDEX);
        setCurrentImageIndex(0);

//        setImage();
    }

//    @Override
//    public void setImage() {
//        this.image = resourcesContext.getOpenedResourcesList().get(0).getOpenedImage();
//    }

    @Override
    public double getScreenPosX() {
        return inGamePosX;
    }

    @Override
    public double getScreenPosY() {
        return inGamePosY;
    }
}
