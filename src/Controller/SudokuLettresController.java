package Controller;

import Model.Sudoku;
import Model.SudokuLettres;
import View.JStatic;
import View.JeuView.JSudoku;
import View.JeuView.JSudokuLettre;
import View.LayoutJeu.JSidebars.JSudokuLettreSidebar;
import View.LayoutJeu.JSidebars.JSudokuSidebar;
import View.LayoutJeu.LayoutJeu;

public class SudokuLettresController extends GrilleController
{
    public SudokuLettresController(SudokuLettres model)
    {
        super(model);
        this.jeuFront = new LayoutJeu(this); // TODO pour les autres controllers
        this.jeuFront.setSidebar(new JSudokuLettreSidebar(this.jeuFront)); // TODO pour les autres controllers
        this.jeuFront.setPanelJeu(new JSudokuLettre(this.jeuFront, (SudokuLettres) this.model)); // TODO pour les autres controllers
        this.jeuFront.setTitle(JStatic.StaticTitre + " Le sudoku lettres");
        this.jeuFront.setVisible(); // TODO pour les autres controllers

        this.addObserver();
    }
}
