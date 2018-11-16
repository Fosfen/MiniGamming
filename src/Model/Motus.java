package Model;

import Observer.Observer;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Motus extends Mots
{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String[] movePossible;// OK pour une lettre bien placé, P pour une lettre mal placé, F pour une lettre complètement fausse.


    public Motus ()
    {
        super();
        movePossible=new String[reponse.length];
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
    }

    protected boolean possede(char c){
        for (int i=0;i<reponse.length;i++){
            if(c==reponse[i]){
                return true;
            }
        }
        return false;
    }

    protected void remplirMovePossible(){
        char[] tabchoix = choix.toCharArray();
        for (int i = 0;i<tabchoix.length;i++){
            if(tabchoix[i]==reponse[i]){
                movePossible[i]="OK";
            }
            else if(possede(tabchoix[i])){
                movePossible[i]="P";
            }
            else{
                movePossible[i]="F";
            }
        }
    }

    protected void initialisation(){
        devoiler2Lettre();
        affichageMot();
    }

    protected void verifierFinPartie()
    {
        for(int i=0;i<movePossible.length;i++){
            if(movePossible[i]!="OK"){
                return;
            }
        }
        progress = false;
    }

    protected void jouerTour(){
        if(nbEssais<6){
            Scanner sc = new Scanner(System.in);
            String entree = sc.nextLine();
            faireUnChoix(entree);
            remplirMovePossible();
            verifierFinPartie();
            affichageMot(choix);
            nbEssais++;
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

    protected void affichageMot(String choix){
        char[] tabchoix = choix.toCharArray();
        for(int i=0;i<reponse.length;i++){
            if(movePossible[i]=="OK"){
                System.out.print(ANSI_RED+reponse[i]+ANSI_WHITE);
            }
            else if(movePossible[i]=="P"){
                System.out.print(ANSI_YELLOW+tabchoix[i]+ANSI_WHITE);
            }
            else{
                System.out.print(tabchoix[i]);
            }
        }
        System.out.println();
    }

    public void jouer(){

        System.out.println(reponse);

        initialisation();

        while(progress){
            jouerTour();
        }
    }


}
