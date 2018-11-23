package View.JeuView;

import Model.AbstractModel;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;

public abstract class JeuView extends JPanel
{
    protected LayoutJeu layout;
    protected AbstractModel model;

    public JeuView(LayoutJeu layout)
    {
        this.layout = layout;
    }
}
