package Model;

import Observer.Observable;
import Observer.Observer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractModel implements Observable
{
    // Attributs
    protected boolean partieTerminee; // true si la partie est terminée
    protected boolean partieGagnee; // true si la partie est gagnée
    protected int score;

    // Méthodes générales à tous les jeux
    public abstract void jouerTour();
    protected abstract void verifierFinPartie() throws IOException;

    public ArrayList<String[]> classementSudoku;
    public ArrayList<String[]> classementSudokuLettre;
    public ArrayList<String[]> classementPendu;
    public ArrayList<String[]> classementMotus;
    public ArrayList<String[]> classementMotsMeles;

    public AbstractModel()
    {
        this.partieTerminee = false;
        this.partieGagnee = false;
        this.score = 0;

        this.classementSudoku=new ArrayList<>();
        this.classementSudokuLettre=new ArrayList<>();
        this.classementMotus=new ArrayList<>();
        this.classementPendu=new ArrayList<>();
        this.classementMotsMeles=new ArrayList<>();
    }


    public void remplirClassement(String type) throws IOException {

        BufferedReader br = null;
        br = new BufferedReader(new FileReader("src/resCode/Classements/"+type+".csv"));

        ArrayList<String[]> classementCurrent = new ArrayList<>();

        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            classementCurrent.add(line.split(";",2));
        }

        ArrayList<Integer> classementScore = new ArrayList<>();

        for(int i=0;i<classementCurrent.size();i++){
            classementScore.add(Integer.parseInt(classementCurrent.get(i)[i]));
        }

        Collections.sort(classementScore);
        Collections.reverse(classementScore);

        ArrayList<String[]> result = new ArrayList<>();

        int i=0;
        while(i<classementScore.size() && i<10){
            for(int j=0;j<classementCurrent.size();j++){
                if(classementScore.get(i)==Integer.parseInt(classementCurrent.get(j)[0])){
                    result.add(classementCurrent.get(j));
                    classementCurrent.remove(j);
                }
            }
            i++;
        }

        if(type=="sudoku"){
            classementSudoku=result;
        }
        else if(type=="sudokulettre"){
            classementSudokuLettre=result;
        }
        else if(type=="pendu"){
            classementPendu=result;
        }
        else if(type=="motus"){
            classementMotus=result;
        }
        else if(type=="motsmeles"){
            classementMotsMeles=result;
        }
    }

    protected abstract void updateScore(int s);

    // Méthodes du pattern Observer
    protected ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs)
    {
        this.observers.add(obs);
    }

    public void removeObserver ()
    {
        this.observers = new ArrayList<>();
    }

    public abstract void jouerTour(String text, String text1, String text2) throws IOException;

    public void ecrireScoreCSV(String pseudo,String file) throws IOException {

        FileWriter fw = new FileWriter("src/resCode/Classements/"+file+".csv",true);

        fw.write(score+";"+pseudo);
        fw.write("\n");

        fw.close();
    }

    public int getScore()
    {
        return this.score;
    }
}
