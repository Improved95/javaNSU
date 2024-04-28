package org.lab3.model.objects.slashFX;

import org.lab3.model.objects.Constants;
import org.lab3.model.objects.SlashBladeObjectAbstract;

public class SlashFX extends SlashBladeObjectAbstract {
    public SlashFX() {
        setWidth(Constants.FXConstants.SLASH_FX_WIDTH);
        setHeight(Constants.FXConstants.SLASH_FX_HEIGHT);
        setResourcesIndexInResourcesList(Constants.FXConstants.SLASH_FX_ATLAS_INDEX);
        setCurrentImageIndex(0, 0);
    }
}
