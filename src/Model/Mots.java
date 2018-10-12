package Model;

import java.io.File;

public abstract class Mots extends AbstractModel
{
    protected String reponse; // Mot à trouver
    protected String choix; // Choix du joueur

    // Constructeur
    public Mots ()
    {
        // Constructeur de AbstractModel
        super();

        this.choix = "";
        this.reponse = genererMot(new File("fileName")); // Géneration du mot à trouver à partir d'un fichier //TODO
    }

    private String genererMot(File dictionnaire)
    {
        return ""; // TODO
    }
}
