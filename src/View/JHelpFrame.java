package View;

import javax.swing.*;
import java.awt.*;

/**
 *  Frame d'aide pour l'utilisateur.
 */

public class JHelpFrame extends JFrame {
    private JPanel content;
    private JLabel helpTextTitle;
    private JLabel text;


    public JHelpFrame() {
        setVisible(true);

        Font f = new Font("Andika basic", Font.BOLD,15);

        content = new JPanel();
        content.setLayout(new BorderLayout());

        helpTextTitle = new JLabel("Aide MiniGamming");
        helpTextTitle.setFont(f);
        content.add(helpTextTitle, BorderLayout.NORTH);

        text = new JLabel("MiniGamming vous propose différents menus : Le menu Jouer, qui vous permettra d'avoir accès à une selection de 5 jeux (Pendu, Motus, Mots Mélés, Sudoku et Sudoku Lettres)");
        content.add(text, BorderLayout.CENTER);
        setContentPane(content);
        content.setBackground(JStatic.HelpFrameBackgroundColor);
        setTitle(JStatic.StaticTitre + "Aide");
        pack();


    }

}
