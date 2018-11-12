package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * @author Duthoit Raphaël
 * Classe permettant de créer un button d'aide
 */

public class JPlayButton extends JButton implements MouseListener {

    private static int width = 150;
    private static int height = 150;

    public JPlayButton()
    {
        this.setPreferredSize(new Dimension(JPlayButton.width, JPlayButton.height));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setRolloverEnabled(false);
        this.addMouseListener(this);
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/play.png")).getImage().getScaledInstance(JPlayButton.width, JPlayButton.height, Image.SCALE_DEFAULT));
        this.setIcon(II);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/Play_Pressed.png")).getImage().getScaledInstance(JPlayButton.width, JPlayButton.height, Image.SCALE_DEFAULT));
        //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/Play_Entered.png")).getImage().getScaledInstance(JPlayButton.width, JPlayButton.height, Image.SCALE_DEFAULT));
        //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/Play_Entered.png")).getImage().getScaledInstance(JPlayButton.width, JPlayButton.height, Image.SCALE_DEFAULT));
        //foreground
        this.setIcon(II);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/play.png")).getImage().getScaledInstance(JPlayButton.width, JPlayButton.height, Image.SCALE_DEFAULT));
        this.setIcon(II);
    }


}
