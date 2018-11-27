package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SudokuLettres extends AbstractSudoku{

    private static int nbSudoku = 4;
    private ArrayList<String> lettresPossible;

    public SudokuLettres() {
        super(9);
        this.grille=new String[9][9];
        lettresPossible = new ArrayList<>();
        try {
            initialisation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void remplirLettresPossibles(){
        for(int i=0;i<grille.length;i++){
            for (int j=0;j<grille.length;j++){
                if(!lettrePossibleContient((String) grille[i][j]) && !grille[i][j].equals("0")){
                    lettresPossible.add((String) grille[i][j]);
                }
            }
        }
    }

    private boolean lettrePossibleContient(String s){
        for(int i=0;i<lettresPossible.size();i++){
            if(lettresPossible.get(i).equals(s)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void initialisation() throws IOException {
        // choix aléatoire de la grille dans la BD des grilles.

        Random random = new Random();
        int numSudoku = random.nextInt(nbSudoku);


        // Prend une grille aléatoirement dans la BDD.

        BufferedReader br = new BufferedReader(new FileReader("src/resCode/sudokuLettresBDD.txt"));
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
                grille[i][j]=listeLine[count];
                count++;
            }
        }

        remplirMovePossible();
        remplirLettresPossibles();
        affichageSudoku();
        System.out.println(lettresPossible);
        //affichageMovePossible();
        br.close();
    }



    @Override
    public void jouerTour(String V, String X, String Y) {
        String val = V;

        String x =X;

        String y = Y;
        insertElement(val,Integer.parseInt(x),Integer.parseInt(y));
        affichageSudoku();
    }

    @Override
    public void jouerTour() {

    }

    @Override
    protected void verifierFinPartie() {

    }

    @Override
    public void notifyObserver() {

    }
}
