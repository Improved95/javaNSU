package org.lab3.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SlashBladeResourcesView implements ResourcesView {
    private InputStream imageStream;
    private BufferedImage bgImage;

    public SlashBladeResourcesView(String path) throws IOException {
        this.imageStream = this.getClass().getResourceAsStream("../../../../SlashBladeResources/" + path);
        if (this.imageStream == null) {
            throw new IOException();
        }
        this.bgImage = ImageIO.read(this.imageStream);
    }

    @Override
    public BufferedImage getImage() { return bgImage; }

    @Override
    public void close() throws Exception {
        imageStream.close();
    }
}
