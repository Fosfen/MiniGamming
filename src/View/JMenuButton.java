package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/*
 *  @author : Duthoit Raphaël
 *  Dev : classe permettant de définir un bouton personnalisé (remplaçant le JButton)
 */


public class JMenuButton extends JButton implements MouseListener {
    private static int width = (int) (800/100*75);
    private static int height = (int) (220/100*75);

    public JMenuButton(String text) {
        this.setPreferredSize(new Dimension(JMenuButton.width, JMenuButton.height));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setRolloverEnabled(false);
        this.addMouseListener(this);
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonDefaultNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
        this.setIcon(II);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setText(text);
        try {
            Font f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") ); //police pour dyslexiques
            f=f.deriveFont( Font.BOLD,42);
            this.setFont(f);
            //this.getFont().
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       //foreground
    }

    public JMenuButton(String text, int fontSize) {
        this.setPreferredSize(new Dimension(JMenuButton.width, JMenuButton.height));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setRolloverEnabled(false);
        this.addMouseListener(this);
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonDefaultNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
        this.setIcon(II);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setText(text);
        try {
            Font f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") );
            f=f.deriveFont( Font.BOLD,42);
            this.setFont(f);
            //this.getFont().
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //foreground
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonPressedNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
       //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonEnteredNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
        //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonEnteredNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
       //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/buttonDefaultNoText.png")).getImage().getScaledInstance(JMenuButton.width, JMenuButton.height, Image.SCALE_DEFAULT));
        //foreground
        this.setIcon(II);
    }
}
