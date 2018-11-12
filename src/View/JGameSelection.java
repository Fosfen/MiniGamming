package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JGameSelection extends JPanel {




    public JGameSelection() {

        setLayout(new GridLayout(3,3));
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        JPanelGameSelect p1 = new JPanelGameSelect("Sudoku");
        JPanelGameSelect p2 = new JPanelGameSelect("Motus");
        JPanelGameSelect p3 = new JPanelGameSelect("Pendu");
        JPanelGameSelect p4 = new JPanelGameSelect("Sudoku Lettres");
        JPanelGameSelect p5 = new JPanelGameSelect("jeux 5");
        JPanelGameSelect p6 = new JPanelGameSelect("jeux 6");

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);


    }
}
