package Controller;

import Model.MotsMeles;
import Model.Motus;
import View.JStatic;
import View.JeuView.JMotsMeles;
import View.JeuView.JMotus;
import View.LayoutJeu.LayoutJeu;

public class MotsMelesController extends MotsController {

    public MotsMelesController(MotsMeles motsMeles){
        super(motsMeles);
        this.jeuFront = new LayoutJeu(this); // TODO pour les autres controllers
        this.jeuFront.setPanelJeu(new JMotsMeles(this.jeuFront, (MotsMeles) this.model)); // TODO pour les autres controllers
        this.jeuFront.setVisible(); // TODO pour les autres controllers
        this.jeuFront.setTitle(JStatic.StaticTitre + "Le motus");
        this.addObserver();
    }
}
