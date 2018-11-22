package Controller;

import Model.AbstractModel;
import View.LayoutJeu.LayoutJeu;

public abstract class AbstractController
{
    protected AbstractModel model;
    protected LayoutJeu jeuFront;

    // TODO
    // public abstract void finPartie()

    public AbstractController(AbstractModel model)
    {
        this.model = model;
    }

    protected void addObserver()
    {
        this.model.addObserver(this.jeuFront);
    }

    public AbstractModel getModel()
    {
        return this.model;
    }
}
