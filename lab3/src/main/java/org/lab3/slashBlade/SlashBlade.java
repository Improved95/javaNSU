package org.lab3.slashBlade;

import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.javaFx.JavaFxSlashBlade;
import org.lab3.view.javaFx.JavaFxView;
import org.lab3.view.FrameObject;
import org.lab3.view.swing.JFrameSlashBlade;
import org.lab3.view.swing.SwingView;
import org.lab3.view.View;

public class SlashBlade {
    private static Model slashBladeModel = null;
//    private static View swingView = null;
    private static View javaFxView = null;
    private static TickGenerator slashBladeTickGenerator = null;

//    private boolean swingExist = true;
//    private boolean javaFxExist = false;

    public static void initial() {
//        FrameObject jFrameSlashBlade;
        FrameObject javaFxSlashBlade;

        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

//        swingView = new SwingView();
        javaFxView = new JavaFxView();

//        jFrameSlashBlade = new JFrameSlashBlade(1650);
//        jFrameSlashBlade.addDrawableComponent(swingView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

        javaFxSlashBlade = new JavaFxSlashBlade(1650);
        javaFxSlashBlade.addDrawableComponent(javaFxView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

//        slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());
        slashBladeModel.setFrameSize(javaFxSlashBlade.getFrameSize());

//        swingView.setModel(slashBladeModel);
        javaFxView.setModel(slashBladeModel);

        slashBladeTickGenerator.setModel(slashBladeModel);

//        slashBladeTickGenerator.setSwingView(swingView);
        slashBladeTickGenerator.setJavaFxView(javaFxView);

//        slashBladeTickGenerator.setSwingFrame(jFrameSlashBlade);
        slashBladeTickGenerator.setJavaFxFrame(javaFxSlashBlade);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();
    }
}
