package Model;

import java.util.ArrayList;

public class Pendu extends Mots
{
    private ArrayList<Character> lettresChoisies;

    public Pendu ()
    {
        super();
    }

    private void choisirLettre(char lettre)
    {
        char lettreTemp = '\\';
        int i = 0;
        while (i < this.reponse.length || lettreTemp != lettre)
        {
            lettreTemp = this.reponse[i];
            i++;
        }

        if (i == this.reponse.length)
        {
            this.bonneLettre();
        }
        else
        {
            mauvaiseLettre();
        }

        this.lettresChoisies.add(lettre);
        this.verifierFinPartie();
    }

    private void bonneLettre()
    {

    }

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
}
