package View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Duthoit Raphael
 * Navbar s'affichant systématiquement en haut du LayoutJeu
 */

public class JNavbarJeu extends JPanel {

    // On conserve la référence du layout qui l'a chargée
    private LayoutJeu layoutJeu;


    public JNavbarJeu(LayoutJeu L) {

            setBackground(JStatic.NavbarBackgroundColor);
            setLayout(new BorderLayout());
            this.layoutJeu = L;
            Font f = new Font("Andika basic", Font.BOLD,30);

            JButton backbutton = new JButton("Retour au menu des jeux");
            backbutton.addActionListener(arg0 -> Return());
            add(backbutton, BorderLayout.WEST);

            JLabel score = new JLabel("Score : ");
            score.setFont(f);
            add(score, BorderLayout.EAST);
        }

        public void Return(){
          layoutJeu.setPanel(new JPanel());
          layoutJeu.setVisible(false);
        }
}
