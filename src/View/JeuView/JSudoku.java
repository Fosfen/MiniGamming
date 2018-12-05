package View.JeuView;

import Model.Sudoku;
import View.LayoutJeu.LayoutJeu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JSudoku extends JGrille
{
    JPanel chiffreSupport;

    public JSudoku(LayoutJeu layout, Sudoku s)
    {
        super(layout, 9, 9);
        this.model = s;
        this.chiffreSupport = new JPanel(new BorderLayout());
        for(int i=0 ; i < 9 ; i++){
            for(int j=0; j< 9 ; j++){

                JPanel panelSupport = new JPanel(new BorderLayout());
                panelSupport.setBackground(new Color(200,200,200));
                panelSupport.setBorder(BorderFactory.createLineBorder(Color.black));

                Font f = null; //police pour dyslexiques
                try {
                    f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") );
                } catch (FontFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                f=f.deriveFont( Font.BOLD,42);
                JButton button = new JButton(" ");
                if (String.valueOf(s.getGrille()[i][j]).equals(new String("0"))){
                    button.setText(" ");
                    button.setBackground(new Color(230,230,230));
                    add(button);
                }
                else{
                    JLabel chiffre = new JLabel(String.valueOf(s.getGrille()[i][j]));
                    chiffre.setFont(f);
                    button.setText(chiffre.getText());
                    button.setBackground(new Color(147,190,230));
                    add(button);
                }
            }
        }
    }


    @Override
    public void updateProgress(String progress)
    {

    }
}
