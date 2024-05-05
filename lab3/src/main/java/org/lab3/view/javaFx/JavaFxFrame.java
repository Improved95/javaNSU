package org.lab3.view.javaFx;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

public class JavaFxFrame {
    private FrameSize frameSize;
    private JavaFxView view;

    public JavaFxFrame() {
    }

    public void setView(JavaFxView view) {
        this.view = view;
    }

    public void createJavaFxFrame() {
        JavaFxWindow.setView(view);
        JavaFxWindow.setFrameSize(frameSize);
        JavaFxWindow.main(null);
    }

    public void addInputListeners(KeyListenerController keyListenerController) {
        JavaFxWindow.setInputListeners(keyListenerController);
    }

    public void repaintObjects() {
        JavaFxWindow.repaint();
    }

    public void close() {
        JavaFxWindow.close();
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }
}
