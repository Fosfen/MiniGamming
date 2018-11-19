package View.JeuView;

import Controller.PenduController;
import Model.AbstractModel;
import Model.Pendu;
import View.JIcone;
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
    JIcone imgdebut = new JIcone("res/penduProgress/Step1.png");

    /**
     * Constructeur JPendu
     */
    public JPendu(PenduController penduController)
    {
        super(penduController);

        JPanel centeredWord = new JPanel();
        centeredWord.setLayout(new FlowLayout(FlowLayout.CENTER));


        pendu = this.controller.getModel();
        progress = new JLabel(this.makeLabel(((Pendu) pendu).getProgressionUser()));
        progress.setHorizontalTextPosition(SwingConstants.CENTER);
        Font f = new Font("Andika basic", Font.BOLD, 70);
        progress.setFont(f);

        //ajout du mot centré au panel
        centeredWord.add(progress);
        centeredWord.setBackground(JStatic.CouleurMotATrouver);

        setLayout(new BorderLayout());                                                //Layout du pendu
        setBackground(JStatic.BackgroundColor);                                       //On ajoute la couleur statique de fond

        System.out.println(String.valueOf(((Pendu)pendu).getReponse()));
        add(centeredWord, BorderLayout.NORTH);

        JPanel panelImgCentered = new JPanel();
        panelImgCentered.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelImgCentered.setBackground(JStatic.BackgroundColor);

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

    public JIcone getImgdebut() {
        return imgdebut;
    }

    public void update(String field)
    {
        this.progress.setText(this.makeLabel(((Pendu) pendu).getProgressionUser()));
    }
}
