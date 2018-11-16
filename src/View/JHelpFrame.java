package View;

import javax.swing.*;
import java.awt.*;

/**
 *  Frame d'aide pour l'utilisateur.
 */

public class JHelpFrame extends JFrame {
    private JPanel content;
    private JLabel HelpTextTitle;
    private JLabel Text;


    public JHelpFrame() {
        setVisible(true);

        Font f = new Font("Andika basic", Font.BOLD,15);

        content = new JPanel();
        content.setLayout(new BorderLayout());

        HelpTextTitle = new JLabel("Aide MiniGamming");
        HelpTextTitle.setFont(f);
        content.add(HelpTextTitle, BorderLayout.NORTH);

        Text = new JLabel("MiniGamming vous propose différents menus : Le menu Jouer, qui vous permettra d'avoir accès à une selection de 5 jeux (Pendu, Motus, Mots Mélés, Sudoku et Sudoku Lettres)");
        content.add(Text, BorderLayout.CENTER);
        setContentPane(content);
        setSize(700,500);
        content.setBackground(JStatic.HelpFrameBackgroundColor);
        setTitle(JStatic.StaticTitre + "Aide");



    }

}
