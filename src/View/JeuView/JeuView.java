package View.JeuView;

import Model.AbstractModel;
import Observer.Observer;
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

    public AbstractModel getModel()
    {
        return this.model;
    }

    public abstract void updateProgress(String progress);
}
