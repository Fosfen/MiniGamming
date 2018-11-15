package View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Duthoit Raphael
 * Navbar s'affichant systématiquement en haut du LayoutMenu
 */

public class JNavbarMenu extends JPanel {

    // On conserve la référence du layout qui l'a chargée
    private LayoutMenu layoutMenu;

    //Bouton Retour de la navbar
    private JButton BackButton;

    //bouton aide de la navbar
    private JHelpButton help;

    public JNavbarMenu(LayoutMenu L) {
            setBackground(JStatic.NavbarBackgroundColor);
            setLayout(new BorderLayout());
            this.layoutMenu = L;

            //TODO : Button A designer
            BackButton = new JButton();
            BackButton.setText("Retour à l'acceuil");
            BackButton.addActionListener(arg0 -> Return());
            add(BackButton, BorderLayout.WEST);

            help = new JHelpButton();
            add(help, BorderLayout.EAST);
            help.addActionListener(arg0 -> new JHelpFrame());

        }

        private void Return() {
            this.layoutMenu.setVisible(false);
            this.layoutMenu.getAccueil().setVisible(true);
        }


}
