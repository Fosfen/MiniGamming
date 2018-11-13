package View;

import javax.swing.*;

/*
 * @author Duthoit Raphael
 * Frame permettant de gérer les panels du Menu
 */

public class Accueil extends JFrame {

    private JPanel Panel;

    public Accueil() {

        setVisible(true);
        setTitle(JStatic.StaticTitre + "Menu Principal");
        Panel = new JMenu(this);
        setContentPane(Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setResizable(false);
    }

}
