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
    private static View swingView = null;
    private static View javaFxView = null;
    private static TickGenerator slashBladeTickGenerator = null;

    public static void initial() {
        FrameObject jFrameSlashBlade;
//        JavaFxSlashBlade javaFxSlashBlade;

        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();

        swingView = new SwingView();
//        javaFxView = new JavaFxView();

        jFrameSlashBlade = new JFrameSlashBlade(1650);
        jFrameSlashBlade.addDrawableComponent(swingView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

//        javaFxSlashBlade = new JavaFxSlashBlade(1650);
//        javaFxSlashBlade.addDrawableComponent(javaFxView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

        slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());

        swingView.setModel(slashBladeModel);
        slashBladeTickGenerator.setModel(slashBladeModel);
        slashBladeTickGenerator.setView(swingView);
        slashBladeTickGenerator.setJFrameObject(jFrameSlashBlade);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();
    }

    public static void initialSlashBladeWithSwing() {
        FrameObject jFrameSlashBlade;

        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();
        slashBladeView = new SwingView();

        jFrameSlashBlade = new JFrameSlashBlade(1650);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

        slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());

        slashBladeView.setModel(slashBladeModel);
        slashBladeTickGenerator.setModel(slashBladeModel);
        slashBladeTickGenerator.setView(slashBladeView);
        slashBladeTickGenerator.setJFrameObject(jFrameSlashBlade);

        slashBladeTickGenerator.initial();
        slashBladeTickGenerator.executeCalculateGame();
    }

    public static void initialSlashBladeWithJavaFx() {
        JavaFxSlashBlade javaFxSlashBlade;

        slashBladeTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();
        javaFxView = new JavaFxView();

        javaFxSlashBlade = new JavaFxSlashBlade(1650);
        javaFxSlashBlade.addDrawableComponent(javaFxView, slashBladeTickGenerator.getSlashBladeKeyListenerController());

//        slashBladeView.setModel(slashBladeModel);
//        slashBladeCTickGenerator.setModel(slashBladeModel);
//        slashBladeCTickGenerator.setView(slashBladeView);
//        slashBladeCTickGenerator.setJFrameObject(javaFxSlashBlade);
//
//        slashBladeCTickGenerator.initial();
//        slashBladeCTickGenerator.executeCalculateGame();
    }
}
