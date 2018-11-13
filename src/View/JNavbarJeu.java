package View;

import javax.swing.*;
import java.awt.*;

/*
 * @author Duthoit Raphael
 * Navbar s'affichant systématiquement en haut du LayoutMenu
 */

public class JNavbarJeu extends JPanel {

    // On conserve la référence du layout qui l'a chargée
    private LayoutJeu layoutJeu;


    public JNavbarJeu(LayoutJeu L) {
            setBackground(JStatic.NavbarBackgroundColor);
            setLayout(new BorderLayout());
            this.layoutJeu = L;
            Font f = new Font("Andika basic", Font.BOLD,30);
            JLabel contenu = new JLabel("contenu de la navbar jeu");
            contenu.setFont(f);
            add(contenu);
        }
}
