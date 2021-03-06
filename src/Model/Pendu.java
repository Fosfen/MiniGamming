package Model;

import Observer.Observer;
import java.util.Scanner;
import java.io.IOException;

import java.io.IOException;
import java.util.Scanner;

public class Pendu extends Mots
{
    private char[] progressionUser;
    private String fileName;

    public Pendu ()
    {
        super();

        this.fileName = "res/penduProgress/Step1.png";
        this.progressionUser = new char[this.reponse.length];
        this.initProgress();
    }

    @Override
    protected void updateScore(int s) {
       this.score += s;
    }

    @Override
    public void jouerTour(String text, String text1, String text2) {

    }

    private void initProgress()
    {
        for (int i = 1; i < this.reponse.length; i++)
        {
            this.progressionUser[i] = '_';
        }

        try {
            this.choisirLettre(this.reponse[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jouerTour()
    {

    }

    // L'utilisateur choisi une lettre
    public void choisirLettre(char lettre) throws IOException {
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

        this.updateProgression(Character.toUpperCase(lettre));
        this.notify(String.valueOf(this.progressionUser));
        // On ajoute la lettre aux lettres choisies et on vérifie si la partie est terminée
        this.verifierFinPartie();
    }

    // La lettre choisie est bonne, on effectue le traitement
    private void bonneLettre(char lettre)
    {
        updateScore(100);
    }

    // La lettre choisie n'est pas bonne, on effectue le traitement
    private void mauvaiseLettre(char lettre)
    {
        this.nbEssais ++;
        this.fileName = "res/penduProgress/Step" + this.nbEssais + ".png";
        this.updateScore(-25);
    }

    // Un tour a été joué, on vérifie si la partie est terminée où si elle continue
    protected void verifierFinPartie() throws IOException {
        if (nbEssais == 8)
        {
            this.partieTerminee = true;
            if (this.progressionUser == this.reponse)
            {
                this.partieGagnee = true;

                ecrireScoreCSV("default","pendu");
            }
        }
    }

    private void updateProgression(char lettre)
    {
        for ( int i = 0 ; i < reponse.length ; i++)
        {
            if(lettre == reponse[i])
            {
                this.progressionUser[i]=lettre;
            }
        }
    }

    public char[] getProgressionUser()
    {
        return this.progressionUser;
    }

    public void notifyObserver()
    {

    }

    public void notify(String progress)
    {
        for (Observer obs : this.observers)
        {
            obs.updateScore();

            String progression = "";
            for (int i = 0; i < this.progressionUser.length; i++)
            {
                progression += this.progressionUser[i] +  " ";
            }
            obs.updateProgress(progression);
        }
    }

    public String getFileName()
    {
        return this.fileName;
    }


    public static void main(String[] args) throws IOException {
        Pendu pendu = new Pendu();

        for (int i = 0; i < pendu.progressionUser.length; i++) {
            System.out.print(pendu.getProgressionUser()[i] + " ");
        }

        while (!pendu.partieTerminee) {
            Scanner sc = new Scanner(System.in);
            pendu.choisirLettre(sc.nextLine().charAt(0));
            for (int i = 0; i < pendu.progressionUser.length; i++) {
                System.out.print(pendu.getProgressionUser()[i] + " ");
            }
        }

        if (pendu.partieGagnee) {
            System.out.println("Gagné !!");
        } else {
            System.out.println("Perdu");
        }
    }}

