package Controller;

import Model.Pendu;
import View.JStatic;
import View.JeuView.JPendu;
import View.LayoutJeu.JSidebars.JPenduSidebar;
import View.LayoutJeu.LayoutJeu;

public class PenduController extends MotsController
{
    public PenduController(Pendu pendu)
    {
        super(pendu);

        this.jeuFront = new LayoutJeu(this); // TODO pour les autres controllers
        this.jeuFront.setSidebar(new JPenduSidebar(this.jeuFront)); // TODO pour les autres controllers
        this.jeuFront.setPanelJeu(new JPendu(this.jeuFront, (Pendu) this.model)); // TODO pour les autres controllers
        this.jeuFront.setVisible(); // TODO pour les autres controllers
        this.jeuFront.setTitle(JStatic.StaticTitre + "Le pendu");
        this.addObserver();
    }

    public void lettreChoisie(char lettre)
    {
        ((Pendu) this.model).choisirLettre(lettre);
    }
}
