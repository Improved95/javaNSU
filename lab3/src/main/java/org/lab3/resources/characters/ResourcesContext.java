package org.lab3.resources.characters;

import org.lab3.resources.bg.SlashBladeViewBG;
import org.lab3.resources.bg.ViewBG;

public class ResourcesContext implements AutoCloseable {
    private ViewBG bgImage;

    public ResourcesContext() {
        this.bgImage = new SlashBladeViewBG();
    }

    @Override
    public void close() throws Exception {

    }
}
