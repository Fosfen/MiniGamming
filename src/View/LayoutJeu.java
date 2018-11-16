package View;

import javax.swing.*;
import java.awt.*;

public class LayoutJeu extends JFrame {


    public LayoutJeu() {

        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new JNavbarJeu(this), BorderLayout.NORTH);
        add(new JPenduSidebar(this), BorderLayout.EAST);
    }

    public void setPanel(JPanel panel) {
        add(panel, BorderLayout.CENTER);
    }
}
