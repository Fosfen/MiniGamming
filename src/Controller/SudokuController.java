package Controller;

import Model.Sudoku;
import View.JeuView.JSudoku;
import View.LayoutJeu.LayoutJeu;

public class SudokuController extends GrilleController
{
    public SudokuController(Sudoku model)
    {
        super(model);

        this.addObserver();
    }
}
