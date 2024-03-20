package org.lab3.resources;

import java.io.IOException;
import java.io.InputStream;

public class SlashBladeResourcesView implements ResourcesView {
    private InputStream imageStream;

    public SlashBladeResourcesView(String path) throws IOException {
        this.imageStream = this.getClass().getResourceAsStream("../../../SlashBladeResources/" + path);
        if (this.imageStream == null) {
            throw new IOException();
        }
    }

    @Override
    public InputStream getOpenedResource() {
        return imageStream;
    }

    @Override
    public void close() throws Exception {
        imageStream.close();
    }
}
