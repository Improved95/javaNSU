package org.lab3.view.javaFx;

import org.lab3.model.model.Model;
import org.lab3.view.View;
import org.lab3.view.FrameObject;
import org.lab3.view.openedResources.Level1Resources;
import org.lab3.view.openedResources.OpenedResources;

import java.awt.*;

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

    @Override
    public void drawObject(Graphics g) {}
}
