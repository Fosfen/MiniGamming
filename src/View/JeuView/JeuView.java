package View.JeuView;

import Controller.AbstractController;
import Observer.Observer;

import javax.swing.*;

public abstract class JeuView extends JPanel implements Observer
{
    protected AbstractController controller;

    public JeuView(AbstractController controller)
    {
        this.controller = controller;
    }

    public abstract void update(String field);
}
