package Model;

import java.io.IOException;
import java.util.Random;

public class MotsMeles extends Grille
{
    public static final Character[] lettres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public MotsMeles (int x, int y)
    {
        super(x, y);
        this.grille = new Character[x][y];

        try
        {
            this.initialisation();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateScore(int s) {
        this.score += s;
    }

    @Override
    protected void initialisation() throws IOException
    {
        Random random = new Random();

        int currentLetterNumber;

        for (int i = 0; i < this.tailleX; i++)
        {
            for (int j = 0; j < this.tailleY; j++)
            {
                currentLetterNumber = random.nextInt(25);
                this.grille[i][j] = lettres[currentLetterNumber];
            }
        }
    }

    @Override
    protected void remplirMovePossible() {

    }

    @Override
    protected void jouerTour() {

    }

    @Override
    protected void verifierFinPartie() {

    }

    @Override
    protected void updateScore(int s) {
        
    }

    @Override
    public void notifyObserver() {

    }

    public static void main(String[] args) {
        MotsMeles test = new MotsMeles(20, 20);

        for (int i = 0; i < test.tailleX; i++)
        {
            for (int j = 0; j < test.tailleY; j++)
            {
                System.out.print(test.grille[i][j]);
            }
            System.out.println();
        }
    }
}
