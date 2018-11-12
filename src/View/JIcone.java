package View;

import javax.swing.*;
import java.awt.*;
/*
 * @author : Duthoit Raphael
 * Classe permettant de créer un icone à partir d'un fichier de l'arborescence du projet
 */
public class JIcone extends JLabel{
    private ImageIcon icone;
    private Integer width;
    private Integer height;

    public JIcone(){
        this.setBackground(JStatic.BackgroundColor);
    }

    public JIcone(String nom){
        this.width = null;
        this.height = null;
        this.setBackground(JStatic.BackgroundColor);
        this.icone = new ImageIcon(getClass().getResource(nom));
        this.setIcon(icone);
        this.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
    }

    public JIcone(String nom, int width, int height){
        this.width = width;
        this.height = height;
        this.setBackground(JStatic.BackgroundColor);
        this.icone = new ImageIcon(new ImageIcon(getClass().getResource(nom)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        this.setIcon(icone);
        this.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
    }

    public JIcone(ImageIcon icone){
        this.width = null;
        this.height = null;
        this.setBackground(JStatic.BackgroundColor);
        this.icone = icone;
        this.setIcon(icone);
        this.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
    }

    public JIcone(ImageIcon icone, int width, int height){
        this.width = width;
        this.height = height;
        this.setBackground(JStatic.BackgroundColor);
        this.icone = new ImageIcon(icone.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        this.setIcon(icone);
        this.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcon(String name) {
        if(width != null || height != null) {
            this.icone = new ImageIcon(new ImageIcon(getClass().getResource(name)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        }else{
            this.icone = new ImageIcon(getClass().getResource(name));
        }
        this.setIcon(icone);
        this.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
        this.updateUI();
    }
}
