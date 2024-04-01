package org.lab3.slashBlade;

import org.lab3.controller.controller.SlashBladeController;
import org.lab3.controller.controller.Controller;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

import java.lang.reflect.InvocationTargetException;

public class SlashBlade {
    private JFrameObject jFrameSlashBlade;
    private Model slashBladeModel = null;
    private View slashBladeView = null;
    private Controller slashBladeController = null;

    public SlashBlade() {
        initialSlashBlade();
    }

    private void initialSlashBlade() {
        slashBladeController = new SlashBladeController();
        try {
            slashBladeModel = new SlashBladeModel();
        } catch (ClassNotFoundException | InvocationTargetException |
                 InstantiationException | IllegalAccessException | NoSuchMethodException ex) {

            ex.printStackTrace();
        }
        slashBladeView = new SlashBladeView();

        jFrameSlashBlade = new JFrameSlashBlade(1500);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, SlashBladeController.getSlashBladeKeyListenerController());

        slashBladeController.setModel(slashBladeModel);
        slashBladeController.setView(slashBladeView);

        slashBladeController.initial();
    }
}
