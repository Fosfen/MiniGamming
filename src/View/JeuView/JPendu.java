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
    /**
     * Constructeur JPendu
     */
    public JPendu(PenduController penduController)
    {
        super(penduController);
        AbstractModel pendu = this.controller.getModel();


        setLayout(new BorderLayout());                                                //Layout du pendu
        setBackground(JStatic.BackgroundColor);                                       //On ajoute la couleur statique de fond

        Font f = new Font("Andika basic", Font.BOLD, 70);

        JPanel mot = new JPanel();
        mot.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Création du mot.
        for(int i=0 ; i< (((Pendu)pendu).getProgressionUser().length) ; i++){
            JLabel lettre = new JLabel(String.valueOf((((Pendu)pendu).getProgressionUser()[i])));
            lettre.setFont(f);
            mot.add(lettre);
        }

        System.out.println(String.valueOf(((Pendu)pendu).getReponse()));
        add(mot, BorderLayout.NORTH);

        // TODO Seb : retirer en mode graphique
        JButton jouer = new JButton("JOUER A LA VERSION CONSOLE");               //On donne une possibilité de jeu console en bas dans un bouton
        jouer.addActionListener(arg0 -> lancerPartie());                              //Listener du bouton version console
        add(jouer,BorderLayout.SOUTH);                                                //On ajoute le bouton au sud du pendu
    }

    /**
     * Méthode pour lancer la version console
     */
    public void lancerPartie()
    {
        //this.pendu.lancerPartie();
    }

    @Override
    public void update()
    {
        // TODO update la vue en fonction du modèle
    }
}
