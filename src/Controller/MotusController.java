package Controller;

import Model.Motus;
import Model.Pendu;
import View.JStatic;
import View.JeuView.JMotus;
import View.JeuView.JPendu;
import View.LayoutJeu.JSidebars.JPenduSidebar;
import View.LayoutJeu.LayoutJeu;

import java.io.IOException;

public class MotusController extends MotsController {

    public MotusController (Motus motus){
        super(motus);
        this.jeuFront = new LayoutJeu(this); // TODO pour les autres controllers
        this.jeuFront.setPanelJeu(new JMotus(this.jeuFront, (Motus) this.model)); // TODO pour les autres controllers
        this.jeuFront.setVisible(); // TODO pour les autres controllers
        this.jeuFront.setTitle(JStatic.StaticTitre + "Le motus");
        this.addObserver();
    }

    public void propose(String proposition) throws IOException {
        ((Motus) this.model).jouerTour(proposition);
    }

}
