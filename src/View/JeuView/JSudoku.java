package View.JeuView;

import Model.Sudoku;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;

public class JSudoku extends JGrille
{
    public JSudoku(LayoutJeu layout, Sudoku s)
    {

        super(layout, 9, 9);
        this.model = s;

        //TODO Remove en graphique
        for(int i=0 ; i < 81 ; i++){
            add(new JButton(String.valueOf(i)));
        }
    }
}
