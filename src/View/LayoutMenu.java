package View;

import javax.swing.*;
import java.awt.*;

/**
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
        JNavbarMenu j = new JNavbarMenu(this);                  //Création de la navbar pour les menus
        add(j, BorderLayout.NORTH);                                //On ajoute la navbar au nord du Layout
        add(panel, BorderLayout.CENTER);                           //On ajoute le panel à charger au centre de la page
        setTitle(JStatic.StaticTitre + Titre);                     //On modifie le titre
        setExtendedState(MAXIMIZED_BOTH);                          //On maximise la fenêtre
    }

    public Accueil getAccueil() {
        return accueil;
    }
}
