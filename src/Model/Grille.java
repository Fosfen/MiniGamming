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
}
