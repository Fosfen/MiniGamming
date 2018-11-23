package View.LayoutJeu.JSidebars;

import View.LayoutJeu.LayoutJeu;

import javax.swing.*;

public abstract class JSidebarJeu extends JPanel
{
    protected LayoutJeu layout;

    public JSidebarJeu(LayoutJeu layout)
    {
        this.layout = layout;
    }
}
