package View.JeuView;

import Controller.AbstractController;
import Controller.SudokuController;
import Model.Sudoku;

import javax.swing.*;

public class JSudoku extends JGrille {

    public JSudoku(SudokuController controller) {
        super(controller, 9, 9);

        //TODO Remove
        for(int i=0 ; i < 81 ; i++){
            add(new JButton(String.valueOf(i)));
        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public void update(String field) {

    }
}
