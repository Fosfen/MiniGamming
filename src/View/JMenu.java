package View;

import Controller.AbstractController;
import Controller.PenduController;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author Duthoit Raphael
 * Panel du Menu principal composé de deux sous panels
 */


public class JMenu extends JPanel {
    private Accueil MainFrame;
    private JPanel panelButton;
    private JPanel panelLogo;
    private Clip audioClip;
    private AudioInputStream audioStream;


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
        musique();
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


    public void musique(){
        try {
            if(audioClip != null && audioStream != null){
                audioClip.close();
                audioStream.close();
            }
            File audioFile = new File("src/View/res/music.wav");
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    }
