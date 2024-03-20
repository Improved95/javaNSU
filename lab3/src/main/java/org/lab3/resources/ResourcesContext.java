package org.lab3.resources;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class ResourcesContext implements AutoCloseable {
    AbstractList<ResourcesView> bgImages = new ArrayList<>();

    public void addBgImage(String path) throws IOException {
        bgImages.add(new SlashBladeResourcesView(path));
    }

    @Override
    public void close() throws Exception {
        for (ResourcesView bgImage : bgImages) {
            bgImage.close();
        }
    }
}
