package View.JeuView;

import Controller.PenduController;
import Model.AbstractModel;
import Model.Pendu;
import View.JIcone;
import View.JStatic;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;

/**
 * @author Duthoit Raphael, Delhalle Sebastien
 * Classe permettant de générer un pendu jouable.
 */
public class JPendu extends JeuView
{
    private JLabel progress;
    JIcone imgdebut;

    /**
     * Constructeur JPendu
     */
    public JPendu(LayoutJeu layout, Pendu pendu)
    {
        super(layout);
        this.model = pendu;

        JPanel centeredWord = new JPanel();
        centeredWord.setLayout(new FlowLayout(FlowLayout.CENTER));

        progress = new JLabel(this.makeLabel(pendu.getProgressionUser()));
        progress.setHorizontalTextPosition(SwingConstants.CENTER);
        Font f = new Font("Andika basic", Font.BOLD, 70);
        progress.setFont(f);

        //ajout du mot centré au panel
        centeredWord.add(progress);
        centeredWord.setBackground(JStatic.CouleurMotATrouver);

        setLayout(new BorderLayout());                                                //Layout du pendu
        setBackground(JStatic.BackgroundColor);                                       //On ajoute la couleur statique de fond

        add(centeredWord, BorderLayout.NORTH);

        JPanel panelImgCentered = new JPanel();
        panelImgCentered.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelImgCentered.setBackground(JStatic.BackgroundColor);
        imgdebut = new JIcone();
        imgdebut.setIcon(pendu.getFileName());
        panelImgCentered.add(imgdebut);
        add(panelImgCentered, BorderLayout.CENTER);

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
}