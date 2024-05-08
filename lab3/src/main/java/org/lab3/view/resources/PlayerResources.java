package org.lab3.view.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class PlayerResources extends ResourcesAbstract {
    public PlayerResources() {
        super(1, 1);
    }

    @Override
    public void openResource(String path) {
        try (InputStream imageStream = this.getClass().getResourceAsStream(mainPath + path)) {
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
