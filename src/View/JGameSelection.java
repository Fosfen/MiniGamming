package View;

import javax.swing.*;
import java.awt.*;

public class JGameSelection extends JPanel
{
    // JLabels
    private JLabel titleSudoku;
    private JLabel titlePendu;
    private JLabel titleMotus;

    // JButtons
    private JPlayButton buttonPendu;

    public JGameSelection()
    {
/*
        setLayout(new GridLayout(3,3));
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
*/      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(JStatic.BackgroundColor);
        Font f = new Font("Andika basic", Font.BOLD,70);

        // Pendu
        titlePendu = new JLabel("Pendu");
        titlePendu.setFont(f);
        buttonPendu = new JPlayButton();

        // Sudoku
        titleSudoku = new JLabel("Sudoku");
        titleSudoku.setFont(f);

        // Motus
        titleMotus = new JLabel("Motus");
        titleMotus.setFont(f);

        this.addComponents();

        // TODO Raph : Séparer le lancement des jeux dans différentes méthodes (on redirige l'action listener vers une méthode spécifique au jeu, je l'ai fait pour le pendu)
        buttonPendu.addActionListener(arg0 -> afficherPendu());
    }

    private void addComponents()
    {
        this.add(titlePendu);
        this.add(buttonPendu);

        this.add(titleSudoku);
        this.add(titleMotus);
    }

    private void afficherPendu()
    {
        JPendu jpendu = new JPendu();
        // TODO Raph : attention à ne pas créer un layout jeu pour chaque jeu, normalement il doit être créé avant et on charge un jeu dedans (1 seule création de LayoutJeu)
        LayoutJeu layout = new LayoutJeu(jpendu,"Le Pendu");
    }
}
