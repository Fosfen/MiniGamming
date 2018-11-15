package View;

import javax.swing.*;

/**
 *  Frame d'aide pour l'utilisateur.
 */

public class JHelpFrame extends JFrame {
    private JPanel content;



    public JHelpFrame() {
        setVisible(true);
        content = new JPanel();
        setContentPane(content);
        setSize(700,500);
        content.setBackground(JStatic.HelpFrameBackgroundColor);
        setTitle(JStatic.StaticTitre + "Aide");
    }

}
