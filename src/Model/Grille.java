package Model;

public abstract class Grille<T> extends AbstractModel
{
    int tailleX; // largeur de la grille
    int tailleY; // hauteur de la grille

    T[][] grille; // La grille est un tableau d'élément générique

    public Grille(int tailleX, int tailleY) { // Constructeur
        this.tailleX = tailleX;
        this.tailleY = tailleY;
    }

    public void Remplir(T[][] grille){ // Initialise la grille
    }

}
