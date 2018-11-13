package Model;

import Observer.Observer;

import java.util.ArrayList;

public class Pendu extends Mots
{
    private ArrayList<Character> lettresChoisies;

    public Pendu ()
    {
        super();
    }

    // L'utilisateur choisi une lettre
    private void choisirLettre(char lettre)
    {
        // On vérifie si la lettre est présente dans le mot réponse
        char lettreTemp = '\\';
        int i = 0;
        while (i < this.reponse.length || lettreTemp != lettre)
        {
            lettreTemp = this.reponse[i];
            i++;
        }

        // On fait le traitement en fonction
        if (i == this.reponse.length)
        {
            this.bonneLettre();
        }
        else
        {
            mauvaiseLettre();
        }

        // On ajoute la lettre aux lettres choisies et on vérifie si la partie est terminée
        this.lettresChoisies.add(lettre);
        this.verifierFinPartie();
    }

    // La lettre choisie est bonne, on effectue le traitement
    private void bonneLettre()
    {

    }

    // La lettre choisie n'est pas bonne, on effectue le traitement
    private void mauvaiseLettre()
    {

    }

    @Override
    protected void bonChoix()
    {
        // TODO
    }

    @Override
    protected void mauvaisChoix()
    {
        // TODO
    }

    public void notifyObserver()
    {
        for (Observer obs : this.observers)
        {
            obs.update();
        }
    }
}
