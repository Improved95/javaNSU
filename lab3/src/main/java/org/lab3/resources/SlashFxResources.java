package org.lab3.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SlashFxResources extends ResourcesAbstract {
    public SlashFxResources() {
        super(1, 2);
    }

    @Override
    public void openResource(String path) {
        try (InputStream imageStream = this.getClass().getResourceAsStream("../../../SlashBladeResources/" + path)) {
            image[0][0] = ImageIO.read(imageStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BufferedImage[][] getImage() {
        return image;
    }
}