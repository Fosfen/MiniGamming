package View.JeuView;

import Controller.GrilleController;

import java.awt.*;

public abstract class JGrille extends JeuView {

    private int rows;
    private int cols;

    public JGrille(GrilleController controller, int r , int c){
        super(controller);
        this.rows = r;
        this.cols = c;
        setLayout(new GridLayout(rows,cols));
    }


}
