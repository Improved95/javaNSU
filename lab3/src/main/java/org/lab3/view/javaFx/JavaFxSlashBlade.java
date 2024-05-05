package org.lab3.view.javaFx;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.View;
import org.lab3.view.FrameObject;

public class JavaFxSlashBlade implements FrameObject {
    private FrameSize frameSize = new FrameSize();

    public JavaFxSlashBlade() {
        JavaFxWindow.setFrameSize(frameSize);
        JavaFxWindow.main(null);
    }

    @Override
    public void addDrawableComponent(View view, KeyListenerController keyListenerController) {
        JavaFxWindow.setKeyAndMouseListeners((JavaFxView) view, keyListenerController);
    }

    @Override
    public void repaintObjects() {
        JavaFxWindow.repaint();
    }

    @Override
    public void close() {
        JavaFxWindow.close();
    }

    @Override
    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }
}
