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
    private static SwingView swingView = null;
    private static JavaFxView javaFxView = null;
    private static SwingFrame swingSlashBlade;
    private static JavaFxFrame javaFxFrame;
    private static TickGenerator slashBladeTickGenerator = null;
    private static FrameSize frameSize = new FrameSize();

    public static void initial() {
        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

        frameSize.setWidth(1650);
        frameSize.setHeight(getHeightByWidth());
        slashBladeModel.setFrameSize(frameSize);

        if (definitionForSwing())
            swingView = new SwingView();
        if (definitionForJavaFx())
            javaFxView = new JavaFxView();

        if (definitionForSwing()) swingView.setModel(slashBladeModel);
        if (definitionForJavaFx()) javaFxView.setModel(slashBladeModel);
        slashBladeTickGenerator.setModel(slashBladeModel);

        if (definitionForSwing()) {
            swingSlashBlade = new SwingFrame();
            swingSlashBlade.setFrameSize(frameSize);
            swingSlashBlade.setView(swingView);
            swingSlashBlade.addInputListeners(slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }
        if (definitionForJavaFx()) {
            javaFxFrame = new JavaFxFrame();
            javaFxFrame.setFrameSize(frameSize);
            javaFxFrame.setView(javaFxView);
            javaFxFrame.addInputListeners(slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }

        if (definitionForSwing()) {
            slashBladeTickGenerator.setSwingView(swingView);
            slashBladeTickGenerator.setSwingFrame(swingSlashBlade);
        }
        if (definitionForJavaFx()) {
            slashBladeTickGenerator.setJavaFxView(javaFxView);
            slashBladeTickGenerator.setJavaFxFrame(javaFxFrame);
        }

        if (definitionForSwing()) swingSlashBlade.createSwingFrame();
        if (definitionForJavaFx()) javaFxFrame.createJavaFxFrame();

        new Thread(() -> {
            slashBladeTickGenerator.initial();
            slashBladeTickGenerator.executeCalculateGame();
        }).start();
    }

    private static int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }
}
