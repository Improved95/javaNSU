package org.lab3.view.bg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SlashBladeViewBG implements ViewBG {
    private InputStream imageStream;
    private BufferedImage bgImage;

    public SlashBladeViewBG(String filePath) throws IOException {
        this.imageStream = new FileInputStream(filePath);
        this.bgImage = ImageIO.read(this.imageStream);
    }

    @Override
    public void close() throws Exception {
        imageStream.close();
    }
}
