package View.JeuView;

import Controller.GrilleController;
import View.LayoutJeu.LayoutJeu;

import java.awt.*;

public abstract class JGrille extends JeuView {

    private int rows;
    private int cols;

    public JGrille(LayoutJeu layout, int r , int c)
    {
        super(layout);
        this.rows = r;
        this.cols = c;
        setLayout(new GridLayout(rows,cols));
    }


}
