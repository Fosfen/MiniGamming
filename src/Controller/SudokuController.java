package Controller;

import Model.Sudoku;
import View.JStatic;
import View.JeuView.JSudoku;
import View.LayoutJeu.JSidebars.JSudokuSidebar;
import View.LayoutJeu.LayoutJeu;

public class SudokuController extends GrilleController
{
    public SudokuController(Sudoku model)
    {
        super(model);
        this.jeuFront = new LayoutJeu(this); // TODO pour les autres controllers
        this.jeuFront.setSidebar(new JSudokuSidebar(this.jeuFront)); // TODO pour les autres controllers
        this.jeuFront.setPanelJeu(new JSudoku(this.jeuFront, (Sudoku) this.model)); // TODO pour les autres controllers
        this.jeuFront.setTitle(JStatic.StaticTitre + " Le sudoku");
        this.jeuFront.setVisible(); // TODO pour les autres controllers

        this.addObserver();
    }
}
