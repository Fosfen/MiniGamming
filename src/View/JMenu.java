package View;

import Controller.AbstractController;
import Controller.PenduController;

import javax.swing.*;
import java.awt.*;

/**
 * @author Duthoit Raphael
 * Panel du Menu principal composé de deux sous panels
 */


public class JMenu extends JPanel {
    private Accueil MainFrame;
    private JPanel panelButton;
    private JPanel panelLogo;

    public JMenu(Accueil support) {
        this.MainFrame = support;

        //Définition des sous Panels
        panelLogo = new JPanel();
        panelLogo.setBackground(JStatic.BackgroundColor);
        JIcone logo = new JIcone("res/Logo.png");
        panelLogo.add(logo);

        panelButton = new JPanel();
        panelButton.setBackground(JStatic.BackgroundColor);
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.PAGE_AXIS));

        JMenuButton PlayButton = new JMenuButton("JOUER");
        panelButton.add(Box.createRigidArea(new Dimension(0, 30)));
        PlayButton.addActionListener(arg0 -> LoadGameSelection());
        panelButton.add(PlayButton);

        panelButton.add(Box.createRigidArea(new Dimension(0, 30)));
        JMenuButton BoardButton = new JMenuButton("CLASSEMENTS");
        BoardButton.addActionListener(arg0 -> LoadClassement());
        panelButton.add(BoardButton);

        panelButton.add(Box.createRigidArea(new Dimension(0, 30)));
        JMenuButton ExitButton = new JMenuButton("QUITTER");
        ExitButton.addActionListener(arg0 -> System.exit(0));
        panelButton.add(ExitButton);
        setLayout(new BorderLayout());
        this.add(panelLogo, BorderLayout.LINE_START);
        this.add(panelButton, BorderLayout.CENTER);
        //this.add(new JMot(controller.model.getReponse().length),BorderLayout.SOUTH);
    }
        //Méthode appellée par la lambda expression permettant de charger un LayoutMenu avec un PanelClassement
        private void LoadClassement() {
            this.MainFrame.setVisible(false);
            new LayoutMenu(new JClassement(), "Classement", this.MainFrame);
        }

        private void LoadGameSelection() {
            this.MainFrame.setVisible(false);
            new LayoutMenu(new JGameSelection(), "Choix du jeu", this.MainFrame);
        }
    }
