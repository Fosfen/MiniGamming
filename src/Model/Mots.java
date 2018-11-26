package Model;

import java.io.*;
import java.util.Random;

public abstract class Mots extends AbstractModel
{
    protected char[] reponse; // Mot à trouver
    protected String choix; // Le choix du joueur
    protected int nbEssais; // Nombre d'essais que le joueur à tenté
    protected boolean progress=true;

    // target : valeur correspondant à la ligne du dictionnaire qui sera choisie


    // Constructeur
    public Mots ()
    {
        // Constructeur de AbstractModel
        super();
        
        this.choix = "";
        this.nbEssais = 1;
        this.reponse = genererMot(new File("src/resCode/dictionnaire.txt")).toCharArray(); // Géneration du mot à trouver à partir d'un fichier
    }

    public char[] getReponse()
    {
        return this.reponse;
    }

    // Génère un mot aléatoire à partir du dictionnaire
    public static String genererMot(File dictionnaire)
    {
        final int target = new Random().nextInt(369086)+1;

        try
        {
            FileReader fr = new FileReader(dictionnaire);
            BufferedReader br = new BufferedReader(fr);

            try
            {
                int i = 1;
                while (i < target)
                {
                    br.readLine();
                    i++;
                }

                String motTarget = br.readLine();

                return motTarget;
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }
        catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        }

        return "";
    }

    // L'utilisateur fait un choix du mot à deviner
    protected void faireUnChoix (String choix)
    {
        if(choix.length()==reponse.length){
            this.choix = choix;
        }
    }

    protected void finPartie()
    {
        // TODO
    }
}
