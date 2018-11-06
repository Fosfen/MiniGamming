package View;

import javax.swing.*;
import java.awt.*;

public class JMenu extends JPanel {
          private MenuFrame MainFrame;
          private JPanel panelButton;
          private JPanel panelLogo;

    public JMenu(MenuFrame support) {
        this.MainFrame = support;

        //Définition des sous Panels
        panelLogo = new JPanel();
        panelLogo.setBackground(JStatic.BackgroundColor);
        JIcone logo = new JIcone("res/Logo.png");
        panelLogo.add(logo);

        panelButton = new JPanel();
        panelButton.setBackground(JStatic.BackgroundColor);
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.PAGE_AXIS));

        JButtonMenu PlayButton = new JButtonMenu("JOUER");
        panelButton.add(Box.createRigidArea(new Dimension(0,30)));
        //action associée au bouton
        panelButton.add(PlayButton);

        panelButton.add(Box.createRigidArea(new Dimension(0, 30)));
        JButtonMenu BoardButton = new JButtonMenu("CLASSEMENTS");
        //action associée au bouton
        panelButton.add(BoardButton);

        panelButton.add(Box.createRigidArea(new Dimension(0,30)));
        JButtonMenu SettingsButton = new JButtonMenu("AIDE");
        //action assiciée au bouton
        panelButton.add(SettingsButton);

        panelButton.add(Box.createRigidArea(new Dimension(0, 30)));
        JButtonMenu ExitButton = new JButtonMenu("QUITTER");
        ExitButton.addActionListener(arg0 -> System.exit(0));
        panelButton.add(ExitButton);

        setLayout(new BorderLayout());
        this.add(panelLogo, BorderLayout.LINE_START);
        this.add(panelButton,BorderLayout.CENTER);

    }
}