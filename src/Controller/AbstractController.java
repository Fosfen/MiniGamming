package Controller;

import Model.AbstractModel;
import View.LayoutJeu.LayoutJeu;

public abstract class AbstractController
{
    protected AbstractModel model;
    LayoutJeu jeuFront;

    AbstractController(AbstractModel model)
    {
        this.model = model;
    }

    void addObserver()
    {
        this.model.addObserver(this.jeuFront);
    }

    public AbstractModel getModel()
    {
        return this.model;
    }
}
