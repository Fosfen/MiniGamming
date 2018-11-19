package Model;

import Observer.Observer;

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

    private void initProgress()
    {
        for (int i = 0; i < this.reponse.length; i++)
        {
            this.progressionUser[i] = '_';
        }
    }

    protected void jouerTour()
    {

    }

    // L'utilisateur choisi une lettre
    public void choisirLettre(char lettre)
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

        this.updateProgression(Character.toUpperCase(lettre));
        this.notify(String.valueOf(this.progressionUser));
        // On ajoute la lettre aux lettres choisies et on vérifie si la partie est terminée
        this.verifierFinPartie();
    }

    // La lettre choisie est bonne, on effectue le traitement
    private void bonneLettre(char lettre)
    {

    }

    // La lettre choisie n'est pas bonne, on effectue le traitement
    private void mauvaiseLettre(char lettre)
    {
        this.nbEssais ++;
        this.fileName = "res/penduProgress/Step" + this.nbEssais + ".png";
    }

    // Un tour a été joué, on vérifie si la partie est terminée où si elle continue
    protected void verifierFinPartie()
    {
        if (nbEssais == 8)
        {
            this.partieTerminee = true;
            if (this.progressionUser == this.reponse)
            {
                this.partieGagnee = true;
            }
        }
    }

    private void updateProgression(char lettre){
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
            obs.update(progress);
        }
    }

    public String getFileName()
    {
        return this.fileName;
    }
}
