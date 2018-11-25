package View.JeuView;

import Model.Motus;
import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;

public class JMotus extends JeuView
{
    JPanel grid;
    JTextField saisie;

    public JMotus(LayoutJeu layout, Motus motus)
    {

        super(layout);
        this.model = motus;
        int tailleMots = motus.getReponse().length;
        grid = new JPanel();
        grid.setLayout(new GridLayout(6,tailleMots));
        saisie = new JTextField();
        setLayout(new BorderLayout());
        genererLignes(grid,motus.getProgressionUser(), motus.getMovePossible());
        add(grid,BorderLayout.CENTER);
        add(saisie,BorderLayout.SOUTH);

        //TODO 1 case = 1 Jlabel = 1 Lettre
        //TODO 1 Lettre = 1 couleur
        //TODO SOUS LA GRILLE, DONNER UN CHAMP DE SAISIE UTILISATEUR POUR QU'IL PUISSE SAISIR SES PROPOSITIONS
    }


    public void genererLignes(JPanel panel, char[] tab, String[] colorTab){
            for(int i=0 ; i < tab.length ; i++){
                JLabel lettre = new JLabel(String.valueOf(tab[i]));
                if(colorTab[i] == "OK"){
                    //TODO SET FONT ROUGE
                }
                else if (colorTab[i] == "P") {
                    //TODO SET FONT YELLOW
                }
                add(lettre);
            }
    }

}
