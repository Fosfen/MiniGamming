package Controller;

import Model.Pendu;
import View.JeuView.JPendu;

public class PenduController extends MotsController
{
    public PenduController(Pendu pendu)
    {
        super(pendu);

        this.jeuView = new JPendu();
        this.addObserver();
    }

    public void lettreChoisie(char lettre)
    {

    }
}
