package org.lab3.resources.bg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SlashBladeViewBG implements ViewBG {
    private BufferedImage bgImage;

    public SlashBladeViewBG(InputStream imageStream) throws IOException {
        this.bgImage = ImageIO.read(imageStream);
    }

    @Override
    public BufferedImage getImage() { return bgImage; }
}
