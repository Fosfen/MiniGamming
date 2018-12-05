package Model;

import java.io.IOException;

public abstract class AbstractSudoku<T> extends Grille
{
    public AbstractSudoku(int taille) { // Constructeur
        super(taille, taille);
        this.movePossible = new boolean[9][9];
    }


    protected boolean absentSurLigne (T k, int i)
    {
        for (int j=0; j < grille.length; j++)
            if (grille[i][j] == k)
                return false;
        return true;
    }

    protected boolean absentSurColonne (T k, int j)
    {
        for (int i=0; i < grille.length; i++)
            if (grille[i][j] == k)
                return false;
        return true;
    }

    protected boolean absentSurBloc (T k, int i, int j)
    {
        int _i = i-(i%3), _j = j-(j%3);  // ou encore : _i = 3*(i/3), _j = 3*(j/3);
        for (i=_i; i < _i+3; i++)
            for (j=_j; j < _j+3; j++)
                if (grille[i][j] == k)
                    return false;
        return true;
    }

    protected void affichageSudoku (){
        for(int i=0;i<grille.length;i++){
            for (int j=0;j<grille.length;j++){
                if(j==3 || j==6){
                    System.out.print("|");
                }
                if(j==0){
                    System.out.print("||"+grille[i][j]+ "|");
                }
                else if(j==grille.length-1){
                    System.out.print(grille[i][j]+"||");
                }
                else{
                    System.out.print(grille[i][j]+"|");
                }
            }
            if(i==2 || i==5){
                System.out.println();
                System.out.println(" ---------------------");
            }
            else {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    protected boolean insertElementPossible(T k,int x, int y){
        return (absentSurLigne(k,x) && absentSurColonne(k,y) && absentSurBloc(k,x,y));
    }

    @Override
    protected void updateScore(int s) {
        this.score += s;
    }

    protected boolean insertElement(T k,int x, int y){
        if (insertElementPossible(k,x,y)){
            if(movePossible[x][y]){
                grille[x][y]=k;
                updateScore(100);
                return true;
            }
            return false;
        }
        else{
            if(this.score>25){
                updateScore(-25);
            }
            else{
                this.score=0;
            }
        }
        return false;
    }

    protected boolean gagner(){ //Determine si la grille ne comporte plus de 0.
        java.lang.String compare = "0";
        for(int i=0;i<grille.length;i++) {
            for (int j = 0; j < grille.length; j++) {
                if(grille[i][j].equals(0) || grille[i][j].equals(compare)){
                    return false;
                }
            }
        }
        return true;
    }

    protected void remplirMovePossible() { //Remplie movePossible
        java.lang.String compare = "0";
        for(int i=0;i<grille.length;i++) {
            for (int j = 0; j < grille.length; j++) {
                if(grille[i][j].equals(0) || grille[i][j].equals(compare)){
                    movePossible[i][j]=true;
                }
                else {
                    movePossible[i][j]=false;
                }
            }
        }
    }

    public void jouer() throws IOException { //permet de jouer au Sudoku dans le terminal.

        initialisation();

        while (!gagner()){
            jouerTour();
        }
    }
}
