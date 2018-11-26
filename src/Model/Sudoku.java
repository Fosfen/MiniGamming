package Model;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Sudoku extends AbstractSudoku {

    private static int nbSudoku = 49150;

    public Sudoku() { // Constructeur
        super(9);
        this.grille= new Integer[9][9];
        try {
            initialisation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initialisation() throws IOException { //Initialise le jeu

        // choix aléatoire de la grille dans la BD des grilles.

        Random random = new Random();
        int numSudoku = random.nextInt(nbSudoku);


        // Prend une grille aléatoirement dans la BDD.

        BufferedReader br = new BufferedReader(new FileReader("src/resCode/sudokuBDD.txt"));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null  && count<numSudoku) {
            count++;
        }
        line = br.readLine();
        String[] listeLine = line.split("");

        count = 0;

        for(int i=0;i<grille.length;i++){
            for(int j=0;j<grille.length;j++){
                grille[i][j]=Integer.parseInt(listeLine[count]);
                count++;
            }
        }

        remplirMovePossible();
        affichageSudoku();
        //affichageMovePossible();
        br.close();
    }

    @Override
    public void jouerTour() { // permet de jouer tour dans le terminal
        Scanner sc = new Scanner(System.in);
        System.out.print("Valeur : ");
        String val = sc.nextLine();
        System.out.print("x : ");
        String x = sc.nextLine();
        System.out.print("y : ");
        String y = sc.nextLine();
        insertElement(Integer.parseInt(val),Integer.parseInt(x),Integer.parseInt(y));
        affichageSudoku();
    }

    @Override
    protected void verifierFinPartie()
    {

    }

    @Override
    public void notifyObserver()
    {

    }
}
