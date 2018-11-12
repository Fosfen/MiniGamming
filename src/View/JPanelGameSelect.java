package View;

import javax.swing.*;
import java.awt.*;

public class JPanelGameSelect extends JPanel {

    private JPanel panelNom;
    private JPanel panelPlayButton;

    public JPanelGameSelect(String GameTitle) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        panelNom = new JPanel();
        panelPlayButton = new JPanel();

        JLabel gameTitle = new JLabel(GameTitle);
        gameTitle.setFont(new Font("Andika Basic", Font.BOLD, 40));
        panelNom.add(gameTitle);

        JPlayButton PlayButton = new JPlayButton();
        panelPlayButton.add(PlayButton);

        add(panelNom, BorderLayout.NORTH);
        add(panelPlayButton, BorderLayout.CENTER);
    }

}
