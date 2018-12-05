package View.JeuView;

import Controller.MotusController;
import Model.Motus;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JMotus extends JeuView
{
    JPanel grid;
    JPanel footer;
    JTextField saisie;

    public JMotus(LayoutJeu layout, Motus motus)
    {
        super(layout);

        this.model = motus;
        int tailleMot = motus.getReponse().length;
        JButton validate = new JButton("Valider");

        setLayout(new BorderLayout());

        grid = new JPanel();                                                                //Layout support du motus
        grid.setLayout(new GridLayout(0, tailleMot));

        footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER));
        genererLignes(grid,motus.getProgressionUser(), motus.getMovePossible());            // génération de la première ligne
       
        saisie = new JTextField();
        saisie.setPreferredSize(new Dimension(900,25));

        validate.addActionListener(arg0 -> {
            try {
                ((MotusController) this.layout.getController()).propose(saisie.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        footer.add(saisie);
        footer.add(validate);

        add(grid,BorderLayout.CENTER);          //ajout de la grille au centre de la fenêtre
        add(footer,BorderLayout.SOUTH);
    }


    //TODO INTEGRATION
    public void genererLignes(JPanel panel, char[] tab, String[] colorTab)
    {
        Font f = null; //police pour dyslexiques
        try {
            f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") );
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f=f.deriveFont( Font.BOLD,42);

        for(int i=0 ; i < tab.length ; i++)
        {
            JPanel supportLettre = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lettre = new JLabel(String.valueOf(tab[i]));
            lettre.setFont(f);

            if(colorTab[i] == "OK")
            {
                lettre.setForeground(new Color(211, 51, 14));       //On passe la lettre en rouge si elle est bien placée
            }
            else if (colorTab[i] == "P")
            {
                lettre.setForeground(new Color(255, 200, 47));     //On passe la lettre en jaune si elle contenue dans le mot
            }
            supportLettre.setBorder(BorderFactory.createLineBorder(Color.black));
            supportLettre.add(lettre);
            panel.add(supportLettre);
            panel.validate();
        }
    }

    public void updateProgress(String progress)
    {
        this.genererLignes(this.grid, progress.toCharArray(), ((Motus) this.layout.getController().getModel()).getMovePossible());
    }
}
