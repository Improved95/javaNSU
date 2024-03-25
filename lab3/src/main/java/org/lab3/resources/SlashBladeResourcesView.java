package org.lab3.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SlashBladeResourcesView implements ResourcesView {
    private BufferedImage image;

    public SlashBladeResourcesView(String path) {
        try (InputStream imageStream = this.getClass().getResourceAsStream("../../../SlashBladeResources/" + path)) {
            image = ImageIO.read(imageStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BufferedImage getOpenedImage() {
        return image;
    }
}
