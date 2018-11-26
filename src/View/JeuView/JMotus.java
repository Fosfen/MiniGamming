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
        grid.setLayout(new GridLayout(6, tailleMots));
        saisie = new JTextField();
        setLayout(new BorderLayout());
        genererLignes(grid,motus.getProgressionUser(), motus.getMovePossible());
        add(grid,BorderLayout.CENTER);
        add(saisie,BorderLayout.SOUTH);


    }

    //TODO 1 case = 1 Jlabel = 1 Lettre --> Affichage bizarre...
    //TODO INTEGRATION
    public void genererLignes(JPanel panel,char[] tab, String[] colorTab){
             Font f = new Font("Andika basic", Font.BOLD, 10);
            for(int i=0 ; i < tab.length ; i++){
                JLabel lettre = new JLabel(String.valueOf(tab[i]));
                lettre.setFont(f);
                if(colorTab[i] == "OK"){
                    lettre.setForeground(new Color(255,0,0));       //On passe la lettre en rouge si elle est bien placée
                }
                else if (colorTab[i] == "P") {
                    lettre.setForeground(new Color(255,255,0));     //On passe la lettre en jaune si elle contenue dans le mot
                }
                panel.add(lettre);
            }
    }

}
