package View;

import javax.swing.*;
import java.awt.*;

public class JGameSelection extends JPanel
{
    // JLabels
    private JLabel titleSudoku;
    private JLabel titlePendu;
    private JLabel titleMotus;
    LayoutJeu layout = new LayoutJeu();                                         //On créé une seule instance de LayoutJeu

    // JButtons
    private JPlayButton buttonPendu;

    public JGameSelection()
    {

        layout.setVisible(false);                                               //On cache le LayoutJeu tant que nous somme dans le menu
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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
        layout.setPanel(jpendu);
        layout.setTitle(JStatic.StaticTitre + "Le Pendu");
        layout.setVisible(true);
    }
}
