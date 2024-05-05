package org.lab3.view.javaFx;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.View;
import org.lab3.view.FrameObject;

public class JavaFxSlashBlade implements FrameObject {
    private FrameSize frameSize = new FrameSize();

    public JavaFxSlashBlade(int width) {
        this.frameSize.setWidth(width);
        this.frameSize.setHeight(getHeightByWidth());

        JavaFxWindow.setFrameSize(frameSize);
        JavaFxWindow.main(null);
    }

    @Override
    public void addDrawableComponent(View view, KeyListenerController keyListenerController) {

    }

    @Override
    public void repaintObjects() {

    }

    @Override
    public FrameSize getFrameSize() {
        return null;
    }

    private int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }
}
