package View;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class JPendu extends JPanel {

    private JMot lemotatrouver;

    public JPendu(){
        lemotatrouver = new JMot(10);
        setLayout(new BorderLayout());
        setBackground(JStatic.BackgroundColor);
        add(lemotatrouver, BorderLayout.NORTH);
    }
}

class JMot extends JPanel {

    private int length;
    ArrayList<JLabel> leslettres = new ArrayList<>();

    public JMot(int longeur){
            this.length = longeur;
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(JStatic.CouleurMotATrouver);
        for(int i=1 ; i<=length ; i++) {
            JLabel unknown = new JLabel("_"); //lettre non trouvée
            this.leslettres.add(unknown);
            unknown.setFont(new Font("Andika Basic", Font.BOLD, 70));
            this.add(unknown);  //on l'ajoute autant de fois qu'il y à de lettres dans la nom
        }
    }
}
