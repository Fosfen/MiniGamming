package Model;

import Observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Motus extends Mots
{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String[] movePossible;// OK pour une lettre bien placé, P pour une lettre mal placé, F pour une lettre complètement fausse.
    protected char[] progressionUser;

    public Motus () {
        super();
        movePossible = new String[reponse.length];
        this.progressionUser = new char[this.reponse.length];

        this.devoiler2Lettre();
    }

    protected void devoiler2Lettre(){
        Random r = new Random();
        int rand = r.nextInt(reponse.length);
        movePossible[rand]="OK";
        int rand2 = r.nextInt(reponse.length);
        while(rand2==rand){
            r.nextInt(reponse.length);
        }
        movePossible[rand2]="OK";

        for (int i = 0; i < this.reponse.length; i++)
        {
            if (this.movePossible[i] == "OK")
            {
                this.progressionUser[i] = this.reponse[i];
            }
            else
            {
                this.progressionUser[i] = ' ';
            }
        }
    }

    protected boolean possede(char c){
        for (int i=0;i<reponse.length;i++){
            if(c==reponse[i]){
                return true;
            }
        }
        return false;
    }

    protected int occurenceLettreReponse(char c){
        int result=0;
        for(int i = 0;i<choix.length();i++){
            if(movePossible[i]!="OK" && reponse[i]==c){
                result++;
            }
        }
        return result;
    }

    protected void remplirMovePossible(){
        char[] tabchoix = choix.toCharArray();
        ArrayList<Character> occLettre = new ArrayList<>();
        ArrayList<Integer> occNombre = new ArrayList<>();

        for(int i=0;i<reponse.length;i++){
            boolean exist = false;
            for(int j=0;j<occLettre.size();j++){
                if(occLettre.get(j)==reponse[i]){
                    exist = true;
                    break;
                }
            }
            if(!exist && movePossible[i]!="OK"){
                occLettre.add(reponse[i]);
                occNombre.add(occurenceLettreReponse(reponse[i]));
            }
        }

        for (int i = 0;i<tabchoix.length;i++){
            if(tabchoix[i]==reponse[i] && movePossible[i]!="OK"){

                for(int j=0;j<occLettre.size();j++){
                    if(occLettre.get(j)==tabchoix[i]){
                        if(occNombre.get(j)!=0){
                            occNombre.set(j,occNombre.get(j)-1);
                            break;
                        }
                    }
                }
                movePossible[i]="OK";
            }
            else if(possede(tabchoix[i]) && movePossible[i]!="OK") {

                for (int j = 0; j < occLettre.size(); j++) {
                    if (occLettre.get(j) == tabchoix[i]) {
                        if (occNombre.get(j) != 0) {
                            occNombre.set(j, occNombre.get(j) - 1);
                            movePossible[i] = "P";
                            break;
                        }
                    }
                }
            }
            else if(movePossible[i]!="OK"){
                movePossible[i]="F";
            }
        }
    }

    protected void initialisation(){
        devoiler2Lettre();
        affichageMot();
    }

    @Override
    public void jouerTour() {

    }

    protected void verifierFinPartie() throws IOException {
        for(int i=0;i<movePossible.length;i++){
            if(movePossible[i]!="OK"){
                return;
            }
        }
        ecrireScoreCSV("default","motus");
        System.out.println("Gagné !!");
        progress = false;
    }

    public void jouerTour(String entree) throws IOException {
        if(nbEssais<6){
            if(entree.length()==reponse.length){
                faireUnChoix(entree);
                remplirMovePossible();
                verifierFinPartie();
                affichageMot(choix);
                nbEssais++;

                int score = 0;
                for(int i = 0; i < this.movePossible.length; i++)
                {
                    if (this.movePossible[i] == "OK")
                    {
                        score += 10 * (this.reponse.length - this.nbEssais);
                    }
                    else if (this.movePossible[i] == "P")
                    {
                        score += 5 * (this.reponse.length - this.nbEssais);
                    }

                    this.updateScore(score);
                }
            }
            else{
                System.out.println("Votre mot n'a pas la même taille");
                affichageMot();
            }
        }
        else {
            progress = false;
            finPartie();
        }
    }

    protected void affichageMot(){
        for(int i=0;i<reponse.length;i++){
            if(movePossible[i]=="OK"){
                System.out.print(ANSI_RED+reponse[i]+ANSI_WHITE);
            }
            else if(movePossible[i]=="P"){
                System.out.print(ANSI_YELLOW+reponse[i]+ANSI_WHITE);
            }
            else{
                System.out.print(" _ ");
            }
        }
        System.out.println();
    }

    protected void affichageMot(String choix) {
        char[] tabchoix = choix.toCharArray();
        for (int i = 0; i < reponse.length; i++) {
            if (movePossible[i] == "OK") {
                System.out.print(ANSI_RED + reponse[i] + ANSI_WHITE);
            } else if (movePossible[i] == "P") {
                System.out.print(ANSI_YELLOW + tabchoix[i] + ANSI_WHITE);
            } else {
                System.out.print(tabchoix[i]);
            }
        }
        System.out.println();
    }

    public char[] getProgressionUser() {
        return progressionUser;
    }

    public String[] getMovePossible() {
        return movePossible;
    }

    @Override
    public void notifyObserver() {

    }

    @Override
    protected void updateScore(int s) {
        this.score += s;
    }

    @Override
    public void jouerTour(String text, String text1, String text2) {

    }

}
