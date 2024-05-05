package org.lab3.slashBlade;

import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.javaFx.JavaFxSlashBlade;
import org.lab3.view.javaFx.JavaFxView;
import org.lab3.view.FrameObject;
import org.lab3.view.swing.JFrameSlashBlade;
import org.lab3.view.swing.SwingView;
import org.lab3.view.View;

import static org.lab3.slashBlade.Constants.ViewConstants.definitionForJavaFx;
import static org.lab3.slashBlade.Constants.ViewConstants.definitionForSwing;

public class SlashBlade {
    private static Model slashBladeModel = null;
    private static View swingView = null;
    private static View javaFxView = null;
    private static FrameObject swingSlashBlade;
    private static FrameObject javaFxSlashBlade;
    private static TickGenerator slashBladeTickGenerator = null;
    private static FrameSize frameSize = new FrameSize();

    public static void initial() {
        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

        frameSize.setWidth(1650);
        frameSize.setHeight(getHeightByWidth());

        if (definitionForSwing())
            swingView = new SwingView();
        if (definitionForJavaFx())
            javaFxView = new JavaFxView();


        if (definitionForSwing()) {
            swingSlashBlade = new JFrameSlashBlade();
            swingSlashBlade.addDrawableComponent(swingView, slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }
        if (definitionForJavaFx()) {
           javaFxSlashBlade = new JavaFxSlashBlade();
           javaFxSlashBlade.addDrawableComponent(javaFxView, slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }

        slashBladeModel.setFrameSize(frameSize);
        if (definitionForSwing())
            swingSlashBlade.setFrameSize(frameSize);
        if (definitionForJavaFx())
            javaFxSlashBlade.setFrameSize(frameSize);

        if (definitionForSwing())
            swingView.setModel(slashBladeModel);
        if (definitionForJavaFx())
            javaFxView.setModel(slashBladeModel);

        slashBladeTickGenerator.setModel(slashBladeModel);

        if (definitionForSwing())
            slashBladeTickGenerator.setSwingView(swingView);
        if (definitionForJavaFx())
            slashBladeTickGenerator.setJavaFxView(javaFxView);

        if (definitionForSwing())
            slashBladeTickGenerator.setSwingFrame(swingSlashBlade);
        if (definitionForJavaFx())
            slashBladeTickGenerator.setJavaFxFrame(javaFxSlashBlade);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();
    }

    private static int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }
}
