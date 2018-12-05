package View;

import Controller.MotusController;
import Controller.PenduController;
import Controller.SudokuController;
import Controller.SudokuLettresController;
import Model.Motus;
import Model.Pendu;
import Model.Sudoku;
import Model.SudokuLettres;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JGameSelection extends JPanel
{
    // JLabels
    private JLabel titleSudoku;
    private JLabel titlePendu;
    private JLabel titleMotus;
    private JLabel titleSudokuLettres;
    private JLabel titleMotsMeles;

    // JButtons
    private JPlayButton buttonSudoku;
    private JPlayButton buttonPendu;
    private JPlayButton buttonMotus;
    private JPlayButton buttonSudokuLettres;
    private JPlayButton buttonMotsMeles;

    public JGameSelection()
    {
        setLayout(new GridLayout(5, 1));
        setBackground(JStatic.BackgroundColor);
        Font f = null; //police pour dyslexiques
        try {
            f = Font.createFont(Font.TRUETYPE_FONT,new File("src/View/res/AndBasR.ttf") );
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f=f.deriveFont( Font.BOLD,42);

        // Pendu

        titlePendu = new JLabel("Pendu");
        titlePendu.setFont(f);
        buttonPendu = new JPlayButton();

        // Sudoku

        titleSudoku = new JLabel("Sudoku");
        titleSudoku.setFont(f);
        buttonSudoku = new JPlayButton();

        // Motus

        titleMotus = new JLabel("Motus");
        titleMotus.setFont(f);
        buttonMotus = new JPlayButton();

        //SudokuLettres

        titleSudokuLettres = new JLabel("SudokuLettres");
        titleSudokuLettres.setFont(f);
        buttonSudokuLettres = new JPlayButton();

        //Mots mélés

        titleMotsMeles = new JLabel("Mots mélés");
        titleMotsMeles.setFont(f);
        buttonMotsMeles = new JPlayButton();

        this.addComponents();


        //Listeners Buttons
        buttonPendu.addActionListener(arg0 -> lancerPendu());
        buttonSudoku.addActionListener(arg0 -> lancerSudoku());
        buttonMotus.addActionListener(arg0 -> lancerMotus());
        buttonMotsMeles.addActionListener(arg0 -> lancerMotsMelees());
        buttonSudokuLettres.addActionListener(arg0 -> lancerSudokuLettre());

        //disable sudokuLettres
        buttonMotsMeles.setEnabled(false);
    }

    private void addComponents() {
        this.add(titlePendu);
        this.add(buttonPendu);
        this.add(titleSudoku);
        this.add(buttonSudoku);
        this.add(titleSudokuLettres);
        this.add(buttonSudokuLettres);
        this.add(titleMotus);
        this.add(buttonMotus);
        this.add(titleMotsMeles);
        this.add(buttonMotsMeles);
    }

    public void lancerPendu()
    {
        PenduController penduController = new PenduController(new Pendu());
    }

    public void lancerSudoku() { SudokuController sudokuController = new SudokuController(new Sudoku()); }

    public void lancerMotus(){ MotusController motusController = new MotusController(new Motus());}

    public void lancerSudokuLettre(){ SudokuLettresController sudokuLettresController = new SudokuLettresController(new SudokuLettres()); }

    public void lancerMotsMelees(){
        // TODO
}

}
