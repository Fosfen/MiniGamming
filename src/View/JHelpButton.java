package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Duthoit Raphaël
 * Classe permettant de créer un button d'aide
 */

public class JHelpButton extends JButton implements MouseListener {

    private static int width = 50;
    private static int height = 50;

    public JHelpButton()
    {
        this.setPreferredSize(new Dimension(JHelpButton.width,JHelpButton.height));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setRolloverEnabled(false);
        this.addMouseListener(this);
        ImageIcon II = new ImageIcon(new ImageIcon(getClass().getResource("res/help.png")).getImage().getScaledInstance(JHelpButton.width, JHelpButton.height, Image.SCALE_DEFAULT));
        this.setIcon(II);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
