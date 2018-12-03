package View;

import javafx.beans.binding.ObjectExpression;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JClassement extends JPanel {


    private JPanel panelClassementPendu;
    private JPanel panelClassementSudoku;
    private JPanel panelClassementSudokuLettre;
    private JPanel panelClassementMotus;


    private String[] cols = new String[] {"Position", "Score", "Pseudo" };
    private Object[][] datasMotus = new Object[][]{{"1","Raphael",500},
            {"2","Sebastien",400},
            {"3","Julien", 200},
            {"3","Julien", 200},{"3","Julien", 200},{"3","Julien", 200},{"3","Julien", 200},{"3","Julien", 200},{"3","Julien", 200},{"3","Julien", 200}
};






    public JClassement() {
        setLayout(new GridLayout(0,1));

        //Création des panels
        panelClassementMotus = new JPanel();
        panelClassementSudoku = new JPanel();
        panelClassementPendu = new JPanel();
        panelClassementSudokuLettre = new JPanel();

        //Set Layouts
        panelClassementSudokuLettre.setLayout(new BorderLayout());
        panelClassementSudoku.setLayout(new BorderLayout());
        panelClassementMotus.setLayout(new BorderLayout());
        panelClassementPendu.setLayout(new BorderLayout());

        //Création des labels
        JLabel labelMotus = new JLabel("Classement motus :");
        JLabel labelPendu = new JLabel("Classement pendu :");
        JLabel labelSudoku = new JLabel("Classement sudoku :");
        JLabel labelSudokuLettre = new JLabel("Classement sudoku lettres :");


        //Création classement Motus
        CreerClassement(new Object[][]{{"1","Jean","205"}}, panelClassementMotus);

        //Ajout des labels dans les sous panels
        panelClassementMotus.add(labelMotus,BorderLayout.NORTH);
        panelClassementPendu.add(labelPendu,BorderLayout.NORTH);
        panelClassementSudoku.add(labelSudoku,BorderLayout.NORTH);
        panelClassementSudokuLettre.add(labelSudokuLettre,BorderLayout.NORTH);

        //Création des classements
        //TODO Création classement Motus
        CreerClassement(datasMotus ,panelClassementMotus);

        //TODO Création classement Pendu
        CreerClassement(datasMotus,panelClassementPendu);
        //TODO Création classement Sudoku
        CreerClassement(datasMotus,panelClassementSudoku);
        //TODO Création classement SudokuLettre
        CreerClassement(datasMotus,panelClassementSudokuLettre);
        //Ajout des sous-panels au panel du classement
        add(panelClassementMotus);
        add(panelClassementPendu);
        add(panelClassementSudoku);
        add(panelClassementSudokuLettre);
    }

    //Méthode permettant de créer des Jtables à partir d'une matrice d'objet
    public void CreerClassement(Object[][] datas , JPanel panel){
        JTable table = new JTable(datas,cols);
        //TODO Empecher l'édition des cellules
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
    }


}
