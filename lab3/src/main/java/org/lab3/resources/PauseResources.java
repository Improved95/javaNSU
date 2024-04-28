package org.lab3.resources;

import org.lab3.view.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class PauseResources implements ObjectResources {
    private BufferedImage[][] image = new BufferedImage[2][3];

    @Override
    public void openResource(String path) {
        try (InputStream imageStream = this.getClass().getResourceAsStream("../../../SlashBladeResources/" + path)) {
            BufferedImage fullImage = ImageIO.read(imageStream);
            image[0][0] = fullImage.getSubimage(0, 0, Constants.PauseConstants.PAUSE_BG_WIDTH, Constants.PauseConstants.PAUSE_BG_HEIGHT);

            int fullImageWidth = Constants.PauseConstants.PAUSE_WIDTH;
            int fullImageHeight = Constants.PauseConstants.PAUSE_HEIGHT;
            int pauseButtonWidth = Constants.PauseConstants.PAUSE_BUTTON_WIDTH;
            int pauseButtonHeight = Constants.PauseConstants.PAUSE_BUTTON_HEIGHT;


            image[1][0] = fullImage.getSubimage(fullImageWidth - pauseButtonWidth, 0,
                    pauseButtonWidth, pauseButtonHeight);
            image[1][1] = fullImage.getSubimage(fullImageWidth - pauseButtonWidth, pauseButtonHeight,
                    pauseButtonWidth, pauseButtonHeight);
            image[1][2] = fullImage.getSubimage(fullImageWidth - pauseButtonWidth, pauseButtonHeight * 2,
                    pauseButtonWidth, pauseButtonHeight);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BufferedImage[][] getImage() {
        return image;
    }
}
