package View.JeuView;

import Controller.PenduController;
import Model.AbstractModel;
import Model.Pendu;
import View.JStatic;

import javax.swing.*;
import java.awt.*;

/**
 * @author Duthoit Raphael, Delhalle Sebastien
 * Classe permettant de générer un pendu jouable.
 */
public class JPendu extends JeuView
{
    private JLabel progress;
    AbstractModel pendu;

    /**
     * Constructeur JPendu
     */
    public JPendu(PenduController penduController)
    {
        super(penduController);

        pendu = this.controller.getModel();
        progress = new JLabel(this.makeLabel(((Pendu) pendu).getProgressionUser()));
        progress.setHorizontalTextPosition(SwingConstants.CENTER);
        Font f = new Font("Andika basic", Font.BOLD, 70);
        progress.setFont(f);

        setLayout(new BorderLayout());                                                //Layout du pendu
        setBackground(JStatic.BackgroundColor);                                       //On ajoute la couleur statique de fond

        System.out.println(String.valueOf(((Pendu)pendu).getReponse()));
        add(progress, BorderLayout.NORTH);

        // TODO Seb : retirer en mode graphique
        JButton jouer = new JButton("JOUER A LA VERSION CONSOLE");               //On donne une possibilité de jeu console en bas dans un bouton
        jouer.addActionListener(arg0 -> lancerPartie());                              //Listener du bouton version console
        add(jouer,BorderLayout.SOUTH);                                                //On ajoute le bouton au sud du pendu
    }

    private String makeLabel(char[] progress)
    {
        String label = "";
        for (int i = 0; i < progress.length; i++)
        {
            label += String.valueOf(progress[i]) + ' ';
        }

        return label;
    }

    public void afficher(String mot, Pendu pendu, JPanel panel)
    {
        //Création du mot.
        Font f = new Font("Andika basic", Font.BOLD, 70);
        for(int i=0 ; i< (pendu.getProgressionUser().length) ; i++){
            JLabel lettre = new JLabel(String.valueOf((pendu).getProgressionUser()[i]));
            lettre.setFont(f);
            panel.add(lettre);
        }
    }

    /**
     * Méthode pour lancer la version console
     */
    public void lancerPartie()
    {
        //this.pendu.lancerPartie();
    }

    public void update(String field)
    {
        this.progress.setText(this.makeLabel(((Pendu) pendu).getProgressionUser()));
    }
}
