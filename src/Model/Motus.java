package Model;

import Observer.Observer;

import java.util.Scanner;

public class Motus extends Mots
{
    public Motus ()
    {
        super();
    }

    protected void verifierFinPartie() {
        if (nbEssais == 11)
        {
            this.partieTerminee = true;
        }
    }

    public void notifyObserver() {

    }

    @Override
    protected void updateScore(int s) {
        this.score += s;
    }

    protected void jouerTour() {

    }
}
