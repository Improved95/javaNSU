package org.lab3.slashBlade;

import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.javaFx.JavaFxFrame;
import org.lab3.view.javaFx.JavaFxView;
import org.lab3.view.swing.SwingFrame;
import org.lab3.view.swing.SwingView;

import static org.lab3.slashBlade.Constants.ViewConstants.definitionForJavaFx;
import static org.lab3.slashBlade.Constants.ViewConstants.definitionForSwing;

public class SlashBlade {
    private static Model slashBladeModel = null;
    private static SwingFrame swingFrame;
    private static JavaFxFrame javaFxFrame;
    private static TickGenerator slashBladeTickGenerator = null;
    private static FrameSize frameSize = new FrameSize();

    public static void initial() {
        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

        frameSize.setWidth(1650);
        frameSize.setHeight(getHeightByWidth());
        slashBladeModel.setFrameSize(frameSize);

        if (definitionForSwing()) ;
        slashBladeTickGenerator.setModel(slashBladeModel);

        if (definitionForSwing()) {
            swingFrame = new SwingFrame();
            swingFrame.setFrameSize(frameSize);
            swingFrame.setModel(slashBladeModel);
            swingFrame.addInputListeners(slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }
        if (definitionForJavaFx()) {
            javaFxFrame = new JavaFxFrame();
            javaFxFrame.setFrameSize(frameSize);
            javaFxFrame.setModel(slashBladeModel);
            javaFxFrame.addInputListeners(slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }

        if (definitionForSwing()) slashBladeTickGenerator.setSwingFrame(swingFrame);
        if (definitionForJavaFx()) slashBladeTickGenerator.setJavaFxFrame(javaFxFrame);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();

        if (definitionForSwing()) swingFrame.createSwingFrame();
        if (definitionForJavaFx()) javaFxFrame.main(null);
    }

    private static int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }
}
