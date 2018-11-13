package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JGameSelection extends JPanel {




    public JGameSelection() {
/*
        setLayout(new GridLayout(3,3));
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
*/      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(JStatic.BackgroundColor);
        Font f = new Font("Andika basic", Font.BOLD,70);
        JLabel TitlePendu = new JLabel("Pendu");
        TitlePendu.setFont(f);
        JPlayButton buttonPendu = new JPlayButton();

        JLabel TitleSudoku = new JLabel("Sudoku");
        TitleSudoku.setFont(f);
        JLabel TitleMotus = new JLabel("Motus");
        TitleMotus.setFont(f);

        buttonPendu.addActionListener(arg0 -> new LayoutJeu(new JPendu(),"Le Pendu"));
        add(TitlePendu);
        add(buttonPendu);
        add(TitleSudoku);
        add(TitleMotus);
    }
}
