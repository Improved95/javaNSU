package org.lab3.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class ResourcesAbstract implements ObjectResources {
    protected BufferedImage[][] image;

    public ResourcesAbstract(int s1, int s2) {
        image = new BufferedImage[s1][s2];
    }

    @Override
    public void addImage(int i1, int i2, String path) {
        try (InputStream imageStream = this.getClass().getResourceAsStream("../../../SlashBladeResources/" + path)) {
            image[i1][i2] = ImageIO.read(imageStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BufferedImage[][] getImage() {
        return image;
    }
}
