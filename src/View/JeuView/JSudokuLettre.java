package View.JeuView;

import Model.SudokuLettres;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;

public class JSudokuLettre extends JGrille
{
    JPanel chiffreSupport;

    public JSudokuLettre(LayoutJeu layout, SudokuLettres s)
    {
        super(layout, 9, 9);
        this.model = s;
        this.chiffreSupport = new JPanel(new BorderLayout());

        for(int i=0 ; i < 9 ; i++){
            for(int j=0; j< 9 ; j++){

                JPanel panelSupport = new JPanel(new BorderLayout());

                panelSupport.setBackground(new Color(200,200,200));
                panelSupport.setBorder(BorderFactory.createLineBorder(Color.black));

                Font f = new Font("Andika basic", Font.BOLD, 36);
                JButton button = new JButton(" ");
                if (String.valueOf(s.getGrille()[i][j]).equals(new String("0"))){
                    button.setText(" ");
                    button.setBackground(new Color(230,230,230));
                    add(button);
                }
                else{
                    JLabel lettre = new JLabel(String.valueOf(s.getGrille()[i][j]));
                    lettre.setFont(f);
                    button.setText(lettre.getText());
                    button.setBackground(new Color(147,190,230));
                    add(button);
                }

            }
        }
    }

    @Override
    public void updateProgress(String progress) {
        // TODO
    }
}

