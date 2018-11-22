package View.JeuView;

import View.LayoutJeu.LayoutJeu;

import javax.swing.*;

public class JSudoku extends JGrille
{
    public JSudoku(LayoutJeu layout)
    {
        super(layout, 9, 9);

        //TODO Remove
        for(int i=0 ; i < 81 ; i++){
            add(new JButton(String.valueOf(i)));
        }
    }
}
