package org.lab3.slashBlade;

import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.ViewDefinition;
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
    private static FrameObject jFrameSlashBlade;
    private static FrameObject javaFxSlashBlade;
    private static TickGenerator slashBladeTickGenerator = null;

    public static void initial() {
        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

        if (definitionForSwing())
            swingView = new SwingView();
        if (definitionForJavaFx())
            javaFxView = new JavaFxView();

        if (definitionForSwing()) {
            jFrameSlashBlade = new JFrameSlashBlade(1650);
            jFrameSlashBlade.addDrawableComponent(swingView, slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }
        if (definitionForJavaFx()) {
           javaFxSlashBlade = new JavaFxSlashBlade(1650);
           javaFxSlashBlade.addDrawableComponent(javaFxView, slashBladeTickGenerator.getSlashBladeKeyListenerController());
        }

        if (definitionForSwing())
            slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());
        if (definitionForJavaFx())
        slashBladeModel.setFrameSize(javaFxSlashBlade.getFrameSize());

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
            slashBladeTickGenerator.setSwingFrame(jFrameSlashBlade);
        if (definitionForJavaFx())
            slashBladeTickGenerator.setJavaFxFrame(javaFxSlashBlade);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();
    }
}
