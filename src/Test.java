import Model.Motus;
import Model.Sudoku;
import Model.SudokuLettres;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        //Motus m = new Motus();
        //m.jouer();

        //Sudoku sudoku = new Sudoku();
        //sudoku.jouer();

        SudokuLettres s = new SudokuLettres();
        //s.jouer();

        s.remplirClassement("sudoku");
        for(int i=0;i<s.classementSudoku.size();i++){
            System.out.println(s.classementSudoku.get(i)[0]+"  " +s.classementSudoku.get(i)[1]);
        }
    }
}
