package View;


import javax.swing.*;
import java.awt.*;

public class JMenu extends JPanel
{

    private LayoutMenu MainFrame;   //Frame ou est associé le Menu
    private JPanel panelIco;        //Panel pour l'icone de l'application
    private JPanel panelButton;     //Panel pour les bouttons du menu


    public JMenu(LayoutMenu L) {
        this.MainFrame = L;
        this.setLayout(new BorderLayout());
        this.setBackground(JStatic.BackgroundColor);

        //définition des sous panels
        //panel Ico
        panelIco = new JPanel();
        panelIco.setBackground(JStatic.BackgroundColor);
        JIcone ico = new JIcone("TODO : nom du fichier");


        //panel Button
        panelButton = new JPanel();
        panelButton.setBackground(JStatic.BackgroundColor);
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.PAGE_AXIS));
        panelButton.add(Box.createRigidArea(new Dimension(0,30)));
        String afaire =  "TODO : AJOUT DES BOUTONS DANS LE SOUS PANEL";
    }





}
