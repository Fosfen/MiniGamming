package Model;

import java.io.IOException;

public abstract class Grille<T> extends AbstractModel
{
    protected int tailleX; // largeur de la grille
    protected int tailleY; // hauteur de la grille

    protected T[][] grille; // La grille est un tableau d'élément générique

    protected boolean[][] movePossible; //historique des coups jouer.

    // Constructeur
    public Grille(int tailleX, int tailleY)
    {
        super();

        this.tailleX = tailleX;
        this.tailleY = tailleY;
    }

    protected abstract void initialisation() throws IOException; // Initialise la grille

    protected T[][] getGrille() {
        return grille;
    }

    protected void affichageMovePossible(){
        for(int i=0;i<movePossible.length;i++) {
            for (int j = 0; j < movePossible.length; j++) {
                System.out.print(movePossible[i][j]);
            }
            System.out.println();
        }
    }

    protected abstract void remplirMovePossible();
}
