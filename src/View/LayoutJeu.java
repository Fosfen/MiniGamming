package View;

import resCode.JSidebarJeu;

import javax.swing.*;
import java.awt.*;

public class LayoutJeu extends JFrame {



    public LayoutJeu(JPanel panel, String Titre){

        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        add(new JNavbarJeu(this),BorderLayout.NORTH);
        add(new JSidebarJeu(), BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);
        setTitle(JStatic.StaticTitre + Titre);
    }
}
