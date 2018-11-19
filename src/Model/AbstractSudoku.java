package Model;

import java.io.IOException;

public abstract class AbstractSudoku<T> extends Grille
{
    public AbstractSudoku(int taille) { // Constructeur
        super(taille, taille);
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
    }

    protected boolean insertElementPossible(T k,int x, int y){
        return (absentSurLigne(k,x) && absentSurColonne(k,y) && absentSurBloc(k,x,y));
    }

    protected boolean insertElement(T k,int x, int y){
        if (insertElementPossible(k,x,y)){
            if(movePossible[x][y]){
                grille[x][y]=k;
                return true;
            }
            return false;
        }
        return false;
    }

    protected abstract boolean gagner();

    protected abstract void jouer() throws IOException;
}
