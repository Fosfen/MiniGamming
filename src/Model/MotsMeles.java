package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MotsMeles extends Grille
{
    public static final Character[] lettres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private ArrayList<Integer[]> coordReponses; // Liste des coordonnées des mots réponses (ex : ( [0, 0], [0,1], [0,2] ) pour un mot à 3 lettres situé en haut à gauche (horizontal) )

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

        this.remplirGrille();
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

    private void remplirGrille()
    {
        // Répète la génération d'un mot 10 fois
        for (int i = 0; i < 10; i++)
        {
            char[] currentMot = Mots.genererMot(new File("src/resCode/dictionnaire.txt")).toCharArray(); // Mot à générer
            char targetLetter = currentMot[0]; // On cherche la première lettre du mot
            char currentLetter;
            ArrayList<Integer[]>  coordLettres = new ArrayList<>();

            // On parcours la grille
            for (int j = 0; j < this.tailleX; j++)
            {
                for (int k = 0; k < this.tailleY; k++)
                {
                    currentLetter = (char) this.grille[j][k];

                    // si on trouve la bonne lettre, on y ajoute les coordonnées
                    if (currentLetter == targetLetter)
                    {
                        Integer[] coords = {j, k};
                        coordLettres.add(coords);
                    }
                }
            }

            // On place le mot
            Random rd = new Random();
            Integer[] chosen = coordLettres.get(rd.nextInt(coordLettres.size()));

            // si on ne peut pas placer le mot, on recommence avec un autre
            if (!this.placerMot(currentMot, chosen[0], chosen[1]))
            {
                i--;
            }

        }
    }

    // Place un mot dans la grille en fonction des coordonnées de sa première lettre
    private boolean placerMot (char[] mot, int x, int y)
    {
        boolean[] possible = new boolean[8];

        // on vérifie tous les sens possibles
        if (((x+1) - mot.length) >= 0) possible[0] = true;
        if (((y+1) + mot.length) <= this.tailleY) possible[1] = true;
        if (((x+1) + mot.length) <= this.tailleX) possible[2] = true;
        if (mot.length <= (y-1)) possible[3] = true;
        if (possible[0] && possible[1]) possible[4] = true;
        if (possible[1] && possible[2]) possible[5] = true;
        if (possible[2] && possible[3]) possible[6] = true;
        if (possible[3] && possible[0]) possible[7] = true;

        ArrayList<Integer> possibles = new ArrayList<>();
        for (int i = 0; i < 8; i++)
        {
            if (possible[i]) possibles.add(i);
        }

        // On détermine un sens aléatoire par rapport aux sens possibles
        Random rd = new Random();
        int sens = possibles.get(rd.nextInt(possibles.size()));

        switch (sens)
        {
            case 0:
                if(placementPossible(mot))
                {

                }
                else
                {
                    placerMot(mot, x, y);
                }
                break;
        }

        return true;
    }

    private boolean placementPossible(char[] mot)
    {
        boolean possible = true;
        int i = 0;
        while(i < mot.length && possible)
        {

        }

        return possible;
    }

    @Override
    protected void jouerTour() {

    }

    @Override
    protected void verifierFinPartie() {

    }

    @Override
    public void notifyObserver() {

    }

    // TODO remove
    public static void main(String[] args) {
        MotsMeles test = new MotsMeles(20, 20);

        for (int i = 0; i < test.tailleX; i++)
        {
            for (int j = 0; j < test.tailleY; j++)
            {
                System.out.print(test.grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}
