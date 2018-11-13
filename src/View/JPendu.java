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
        add(lemotatrouver, BorderLayout.NORTH);

    }

}

class JMot extends JPanel {

    private int mot;
    ArrayList<JLabel> leslettres = new ArrayList<>();

    public JMot(int longeur){
            this.mot = longeur;
            setLayout(new FlowLayout(FlowLayout.CENTER));

        for(int i=1 ; i<mot ; i++) {
            JLabel unknown = new JLabel("_"); //lettre non trouvée
            this.leslettres.add(unknown);
            unknown.setFont(new Font("Andika basic", Font.BOLD, 70));
            this.add(unknown);  //on l'ajoute autant de fois qu'il y à de lettres dans la nom
        }
    }
}
