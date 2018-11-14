package resCode;

import View.JStatic;

import javax.swing.*;
import java.awt.*;

public class JSidebarJeu extends JPanel {

    public JSidebarJeu(){
        setLayout(new BorderLayout()); //TODO bon layout à mettre
        setBackground(JStatic.HelpFrameBackgroundColor);
        Font f = new Font("Andika basic", Font.BOLD,30);
        add(new JLabel("contenu sidebar droite"));
    }
}
