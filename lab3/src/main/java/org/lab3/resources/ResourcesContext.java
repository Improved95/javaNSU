package org.lab3.resources;

import org.lab3.resources.bg.SlashBladeViewBG;
import org.lab3.resources.bg.ViewBG;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class ResourcesContext implements AutoCloseable {
    AbstractList<ViewBG> bgImages = new ArrayList<>();

    public void addBgImage(String path) throws IOException {
        bgImages.add(new SlashBladeViewBG(path));
    }

    @Override
    public void close() throws Exception {
        for (ViewBG bgImage : bgImages) {
            bgImage.close();
        }
    }
}
