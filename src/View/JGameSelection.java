package View;

import Controller.PenduController;
import Model.Pendu;
import View.JeuView.JPendu;

import javax.swing.*;
import java.awt.*;

public class JGameSelection extends JPanel
{
    // JLabels
    private JLabel titleSudoku;
    private JLabel titlePendu;
    private JLabel titleMotus;
    private JLabel titleSudokuLettres;
    private JLabel titleMotsMeles;
    LayoutJeu layout = new LayoutJeu();                                         //On créé une seule instance de LayoutJeu

    // JButtons
    private JPlayButton buttonSudoku;
    private JPlayButton buttonPendu;
    private JPlayButton buttonMotus;
    private JPlayButton buttonSudokuLettres;
    private JPlayButton buttonMotsMeles;

    public JGameSelection() {

        layout.setVisible(false);                                               //On cache le LayoutJeu tant que nous somme dans le menu
        setLayout(new GridLayout(5, 1));
        setBackground(JStatic.BackgroundColor);
        Font f = new Font("Andika basic", Font.BOLD, 70);

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

    }

    private void addComponents()
    {
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
        PenduController controller = new PenduController(new Pendu());
        layout.setPanel(controller.getPanel());
        layout.setTitle(JStatic.StaticTitre + "Le pendu");
        layout.setVisible(true);
    }
}
