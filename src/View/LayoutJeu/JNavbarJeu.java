package View.LayoutJeu;

import View.JStatic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Duthoit Raphael
 * Navbar s'affichant systématiquement en haut du LayoutJeu
 */

public class JNavbarJeu extends JPanel
{
    // On conserve la référence du layout qui l'a chargée
    private LayoutJeu layout;
    protected JLabel score;

    public JNavbarJeu(LayoutJeu layout)
    {
        this.layout = layout;
        setBackground(JStatic.NavbarBackgroundColor);
        setLayout(new BorderLayout());
        Font f = null; //police pour dyslexiques
        try {
            f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") );
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f=f.deriveFont( Font.BOLD,42);
        JButton backbutton = new JButton("Retour au menu des jeux");
        backbutton.addActionListener(arg0 -> Return());
        add(backbutton, BorderLayout.WEST);

        this.score = new JLabel("Score : 0");
        score.setFont(f);
        add(score, BorderLayout.EAST);
    }

    public void Return()
    {
        layout.setVisible(false);
    }
}
