package Controller;

import Model.AbstractModel;
import View.JeuView.JeuView;

public abstract class AbstractController
{
    protected AbstractModel model;
    protected JeuView jeuView;

    public AbstractController(AbstractModel model)
    {
        this.model = model;
    }

    protected void addObserver()
    {
        this.model.addObserver(this.jeuView);
    }
}
