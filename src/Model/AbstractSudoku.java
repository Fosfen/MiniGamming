package Model;

public abstract class AbstractSudoku extends Grille
{
    public AbstractSudoku(int taille) { // Constructeur
        super(taille, taille);
    }

    public boolean verifLigne(){ // Vérifie si des occurences sont présentes sur la ligne.
        //TODO
        return false;
    }

    public boolean verifColonne(){ // Vérifie si des occurences sont présentes sur la colonne.
        //TODO
        return false;
    }

    public boolean verifRegion(){ //Verifie si des occurences sont présentes dans le carré courant.
        //TODO
        return false;
    }
}
