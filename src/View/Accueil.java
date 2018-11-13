package View;

import Controller.AbstractController;
import Controller.PenduController;

import javax.swing.*;
import java.util.ArrayList;

/*
 * @author Duthoit Raphael
 * Frame permettant de gérer les panels du Menu
 */

public class Accueil extends JFrame {

    private JPanel Panel;
    protected ArrayList<AbstractController> controllers;

    public Accueil(PenduController controller)
    {
        this.controllers = controllers;

        setVisible(true);
        setTitle(JStatic.StaticTitre + "Menu Principal");
        Panel = new JMenu(this, controller);
        setContentPane(Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setResizable(false);
    }

}
