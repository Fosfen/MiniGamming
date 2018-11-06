package View;

import javax.swing.*;

public class MenuFrame extends JFrame {

    private JPanel oldPanel;
    private JPanel actualPanel;
    String titre;


    public MenuFrame() {

        setVisible(true);
        setTitle("MiniGamming V 1.0");
        actualPanel = new JMenu(this);
        setContentPane(actualPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setResizable(false);

    }

    public void setMainPanel(JPanel panel, String title) {
        this.oldPanel = this.actualPanel;
        this.titre = title;
        this.actualPanel = panel;
        this.setContentPane(actualPanel);
        this.setTitle("MiniGamming V 1.0 : "+titre);
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


}
