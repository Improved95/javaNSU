package org.lab3.view.javaFx;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.lab3.model.model.Model;
import org.lab3.model.objects.DrawObject;
import org.lab3.view.EditedImage;
import org.lab3.view.View;
import org.lab3.view.FrameObject;
import org.lab3.view.openedResources.Level1Resources;
import org.lab3.view.openedResources.OpenedResources;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class JavaFxView implements View {
    private Model model;
    private boolean drawing = false;
    private OpenedResources openedResources;

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }

    @Override
    public void changeViewScreen(FrameObject frameObject) {
        frameObject.repaintObjects();
    }

    @Override
    public void switchGameStateResources() {
        switch (model.getGameState()) {
            case LEVEL1:
                openedResources = new Level1Resources();
                break;
            case MENU:
                break;
        }
    }

    public void drawObject(Group root) {
        if (drawing) {
            List<DrawObject> drawObjectsList = new ArrayList<>(model.getGameModeObjectsContext().getDrawObjectsList());
            drawObjectsList.sort((o1, o2) -> {
                if (o1.getScreenLayerLevel() - o2.getScreenLayerLevel() == 0) {
                    return -1;
                }
                return o1.getScreenLayerLevel() - o2.getScreenLayerLevel();
            });

            root.getChildren().removeAll();
            for (DrawObject drawObject : drawObjectsList) {
                BufferedImage bufferedImage = openedResources.getResourcesList().get(drawObject.getResourcesIndexInResourcesList()).
                        getImage()[drawObject.getCurrentImageIndex().getI1()][drawObject.getCurrentImageIndex().getI2()];

                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                ImageView imageView = new ImageView(image);
                imageView.setX(EditedImage.newPosX);
                imageView.setY(drawObject.getScreenPosY());
                imageView.setFitWidth(EditedImage.newWidth);
                imageView.setFitHeight(drawObject.getScreenHeight());
                root.getChildren().add(imageView);
            }
        }
    }
}
