package View;

import Model.AbstractModel;
import javafx.beans.binding.ObjectExpression;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class JClassement extends JPanel {


    private JPanel panelClassementPendu;
    private JPanel panelClassementSudoku;
    private JPanel panelClassementSudokuLettre;
    private JPanel panelClassementMotus;


    private static String[] cols = new String[] {"Score", "Pseudo"};
    private String[][] datasMotus;
    private String[][] datasSudoku;
    private String[][] datasSudokuLettres;
    private String[][] datasPendu;


    public JClassement() {
        setLayout(new GridLayout(0,1));

        //initialisation des listes de données
        datasMotus = new String[][]{};
        datasSudoku = new String[][]{};
        datasSudokuLettres = new String[][]{};
        datasPendu = new String[][]{};

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

        //Ajout des labels dans les sous panels
        panelClassementMotus.add(labelMotus,BorderLayout.NORTH);
        panelClassementPendu.add(labelPendu,BorderLayout.NORTH);
        panelClassementSudoku.add(labelSudoku,BorderLayout.NORTH);
        panelClassementSudokuLettre.add(labelSudokuLettre,BorderLayout.NORTH);

        try {
            ArrayList<String[]> classementSudoku = AbstractModel.remplirClassement("sudoku");
            CreerClassement(classementSudoku,panelClassementSudoku);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String[]> classementSudokuLettres = AbstractModel.remplirClassement("sudokulettre");
            CreerClassement(classementSudokuLettres, panelClassementSudokuLettre);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String[]> classementMotus = AbstractModel.remplirClassement("motus");
            CreerClassement(classementMotus ,panelClassementMotus);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String[]> classementPendu = AbstractModel.remplirClassement("pendu");
            CreerClassement(classementPendu, panelClassementPendu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ajout des sous-panels au panel du classement
        add(panelClassementMotus);
        add(panelClassementPendu);
        add(panelClassementSudoku);
        add(panelClassementSudokuLettre);
    }

    //Méthode permettant de créer des Jtables à partir d'une ArrayList

    public void CreerClassement(ArrayList<String[]> list, JPanel panel){
        TableModel tableModel = new DefaultTableModel();
        ((DefaultTableModel) tableModel).setColumnIdentifiers(cols);
        JTable table = new JTable(tableModel);
        table.setRowHeight(20);

        for (int i = 0; i < list.size(); i++){
            String score = list.get(i)[0];
            System.out.println(list.get(i)[0]);
            String pseudo = list.get(i)[1];
            System.out.println(list.get(i)[1]);
            Object[] data = {score,pseudo};
            ((DefaultTableModel) tableModel).addRow(data);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

    }
}
