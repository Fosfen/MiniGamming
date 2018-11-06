package Model;

import java.io.*;
import java.util.Random;

public abstract class Mots extends AbstractModel
{
    protected String reponse; // Mot à trouver
    protected String choix; // Choix du joueur

    // target : valeur correspondant à la ligne du dictionnaire qui sera choisie
    private final int target = new Random().nextInt(369086)+1;

    // Constructeur
    public Mots ()
    {
        // Constructeur de AbstractModel
        super();

        this.choix = "";
        this.reponse = genererMot(new File("src/resCode/dictionnaire.txt")); // Géneration du mot à trouver à partir d'un fichier //TODO
    }

    private String genererMot(File dictionnaire)
    {
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
            System.out.println("Le fichier n'a pas été trouvé...");
        }

        return "";
    }

    public String getReponse()
    {
        return this.reponse;
    }
}
