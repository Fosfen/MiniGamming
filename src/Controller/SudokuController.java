package Controller;

import Model.Sudoku;
import View.JeuView.JSudoku;

public class SudokuController extends GrilleController {
    public SudokuController(Sudoku model) {
        super(model);
        this.jeuView = new JSudoku(this);
        this.addObserver();
    }
}
