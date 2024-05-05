package org.lab3.view.javaFx;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.View;
import org.lab3.view.FrameObject;

public class JavaFxSlashBlade implements FrameObject {
    private FrameSize frameSize = new FrameSize();
    private JavaFxWindow javaFxWindow;

    public JavaFxSlashBlade(int width) {
        this.frameSize.setWidth(width);
        this.frameSize.setHeight(getHeightByWidth());

        javaFxWindow = new JavaFxWindow();
        javaFxWindow.setFrameSize(frameSize);
        javaFxWindow.main(null);
    }

    @Override
    public void addDrawableComponent(View view, KeyListenerController keyListenerController) {
        javaFxWindow.setKeyAndMouseListeners(view, keyListenerController);
    }

    @Override
    public void repaintObjects() {
        javaFxWindow.repaint();
    }

    @Override
    public FrameSize getFrameSize() {
        return frameSize;
    }

    private int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }
}
