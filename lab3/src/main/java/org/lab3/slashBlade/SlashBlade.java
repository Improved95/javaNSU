package org.lab3.slashBlade;

import org.lab3.controller.controller.SlashBladeController;
import org.lab3.controller.controller.Controller;
import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.javaFx.JavaFxWindow;
import org.lab3.view.swing.JFrameObject;
import org.lab3.view.swing.JFrameSlashBlade;
import org.lab3.view.swing.SwingView;
import org.lab3.view.View;

public class SlashBlade {
    private JFrameObject jFrameSlashBlade;
    private JavaFxWindow javaFxWindow;
    private Model slashBladeModel = null;
    private View slashBladeView = null;
    private Controller slashBladeController = null;

    public SlashBlade() {
        initialSlashBlade();
    }

    private void initialSlashBlade() {
        slashBladeController = new SlashBladeController();
        slashBladeModel = new SlashBladeModel();
        slashBladeView = new SwingView();

        javaFxWindow = new JavaFxWindow();


        jFrameSlashBlade = new JFrameSlashBlade(1650);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, slashBladeController.getSlashBladeKeyListenerController());

        slashBladeModel.setFrameSize(jFrameSlashBlade.getFrameSize());

        slashBladeView.setModel(slashBladeModel);
        slashBladeController.setModel(slashBladeModel);
        slashBladeController.setView(slashBladeView);
        slashBladeController.setJFrameObject(jFrameSlashBlade);

        slashBladeController.initial();
        slashBladeController.executeCalculateGame();
    }
}
