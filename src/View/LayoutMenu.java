package View;

import javax.swing.*;
import java.awt.*;

/*
 * @author Duthoit Raphaël
 * Layout de chaque sous menu de l'accueil
 */


public class LayoutMenu extends JFrame {

    //lien avec l'acceuil qui à chargé le Layout en cas de retour
    private Accueil accueil;


    public LayoutMenu(JPanel panel, String Titre, Accueil a)
    {
        this.setLayout(new BorderLayout());
        this.accueil = a;
        setVisible(true);
        JNavbarMenu j = new JNavbarMenu(this);
        add(j, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setTitle(JStatic.StaticTitre + Titre);
        setExtendedState(MAXIMIZED_BOTH);
    }

    public Accueil getAccueil() {
        return accueil;
    }
}
