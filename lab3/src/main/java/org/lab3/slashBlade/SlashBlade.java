package org.lab3.slashBlade;

import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.javaFx.JavaFxSlashBlade;
import org.lab3.view.javaFx.JavaFxView;
import org.lab3.view.FrameObject;
import org.lab3.view.swing.FrameSlashBlade;
import org.lab3.view.swing.SwingView;
import org.lab3.view.View;

public class SlashBlade {
    private static Model slashBladeModel = null;
    private static View slashBladeView = null;
    private static TickGenerator slashBladeCTickGenerator = null;

    public static void initialSlashBladeWithSwing() {
        FrameObject jFrameSlashBlade;

        slashBladeCTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();
        slashBladeView = new SwingView();

        jFrameSlashBlade = new FrameSlashBlade(1650);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, slashBladeCTickGenerator.getSlashBladeKeyListenerController());

        slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());

        slashBladeView.setModel(slashBladeModel);
        slashBladeCTickGenerator.setModel(slashBladeModel);
        slashBladeCTickGenerator.setView(slashBladeView);
        slashBladeCTickGenerator.setJFrameObject(jFrameSlashBlade);

        slashBladeCTickGenerator.initial();
        slashBladeCTickGenerator.executeCalculateGame();
    }

    public static void initialSlashBladeWithJavaFx() {
        JavaFxSlashBlade javaFxSlashBlade;

        slashBladeCTickGenerator = new TickGenerator();
        slashBladeModel = new SlashBladeModel();
        slashBladeView = new JavaFxView();

        javaFxSlashBlade = new JavaFxSlashBlade(1650);
//        javaFxSlashBlade.addDrawableComponent(slashBladeView, slashBladeCTickGenerator.getSlashBladeKeyListenerController());

//        slashBladeView.setModel(slashBladeModel);
//        slashBladeCTickGenerator.setModel(slashBladeModel);
//        slashBladeCTickGenerator.setView(slashBladeView);
//        slashBladeCTickGenerator.setJFrameObject(javaFxSlashBlade);
//
//        slashBladeCTickGenerator.initial();
//        slashBladeCTickGenerator.executeCalculateGame();
    }
}
