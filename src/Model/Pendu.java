package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Pendu extends Mots
{
    private ArrayList<Character> lettresChoisies;
    private char[] progressionUser;

    public Pendu ()
    {
        super();
        this.lettresChoisies = new ArrayList<>();

        this.progressionUser = new char[this.reponse.length];
        this.initPregress();
    }

    private void initPregress()
    {
        for (int i = 0; i < this.reponse.length; i++)
        {
            this.progressionUser[i] = '_';
        }
    }

    protected void jouerTour()
    {
        // TODO Julien
        // TODO intégrer la fonctionnalité > passer du mode console au mode graphique
        System.out.println("Choisissez une lettre : ");
        Scanner sc = new Scanner(System.in);
        this.choisirLettre(sc.next().charAt(0));
    }

    // L'utilisateur choisi une lettre
    private void choisirLettre(char lettre)
    {
        // On vérifie si la lettre est présente dans le mot réponse
        char lettreTemp = '\\';
        int i = 1;
        while (i < this.reponse.length+1 && lettreTemp != Character.toUpperCase(lettre))
        {
            lettreTemp = this.reponse[i-1];

            if (lettreTemp != Character.toUpperCase(lettre))
            {
                i++;
            }
        }

        // On fait le traitement en fonction
        if (i == this.reponse.length+1)
        {
            this.mauvaiseLettre(lettre);
        }
        else
        {
            this.bonneLettre(lettre);
        }

        // TODO Seb : Modifier la variable progressionUser lorqu'une lettre est choisie
        // On ajoute la lettre aux lettres choisies et on vérifie si la partie est terminée
        this.lettresChoisies.add(lettre);
        this.nbEssais ++;
        this.verifierFinPartie();
    }

    // La lettre choisie est bonne, on effectue le traitement
    private void bonneLettre(char lettre)
    {
        // TODO
        System.out.println("Bonne lettre");
    }

    // La lettre choisie n'est pas bonne, on effectue le traitement
    private void mauvaiseLettre(char lettre)
    {
        // TODO
        System.out.println("Mauvaise lettre");
    }

    // Un tour a été joué, on vérifie si la partie est terminée où si elle continue
    protected void verifierFinPartie()
    {
        if (nbEssais < 3)
        {
            jouerTour();
        }
        else
        {
            this.finPartie();
        }
    }

    private void UpdateProgression(char lettre){
        for ( int i = 0 ; i < reponse.length ; i++){
            if(lettre == reponse[i]){                   // si égalité
                progressionUser[i]=lettre;
            }
        }
    }


    public char[] getProgressionUser()
    {
        return this.progressionUser;
    }
}
