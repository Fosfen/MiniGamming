package View.LayoutJeu;

import Controller.AbstractController;
import Observer.Observer;
import View.JeuView.JeuView;
import View.LayoutJeu.JSidebars.JSidebarJeu;

import javax.swing.*;
import java.awt.*;

public class LayoutJeu extends JFrame implements Observer
{
    AbstractController controller;

    JNavbarJeu navbar;
    JSidebarJeu sidebar;
    JeuView panelJeu;

    public LayoutJeu(AbstractController controller)
    {
        this.controller = controller;
        this.navbar = new JNavbarJeu(this);

        this.setLayout(new BorderLayout());
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setSidebar(JSidebarJeu sidebar)
    {
        this.sidebar = sidebar;
        add(sidebar, BorderLayout.EAST);
    }

    public void setPanelJeu(JeuView panelJeu)
    {
        this.panelJeu = panelJeu;
        add(panelJeu, BorderLayout.CENTER);
    }

    public void setVisible()
    {
        this.setVisible(true);
    }

    public AbstractController getController()
    {
        return this.controller;
    }
}
