package View.JeuView;

import Model.Motus;
import View.LayoutJeu.LayoutJeu;

import java.awt.*;

public class JMotus extends JeuView
{
    public JMotus(LayoutJeu layout, Motus motus)
    {

        super(layout);
        this.model = motus;
        int tailleMots = motus.getReponse().length;
        setLayout(new GridLayout(6,tailleMots));



        //TODO 1 case = 1 Jlabel = 1 Lettre
        //TODO 1 Lettre = 1 couleur
        //TODO SOUS LA GRILLE, DONNER UN CHAMP DE SAISIE UTILISATEUR POUR QU'IL PUISSE SAISIR SES PROPOSITIONS
    }


    public void genererLignes(char[] tab){
            for(int i=0 ; i < tab.length ; i++){

            }
    }

}
