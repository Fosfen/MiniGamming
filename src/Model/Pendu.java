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
}
