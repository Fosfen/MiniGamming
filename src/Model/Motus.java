package Model;

import Observer.Observer;

import java.util.Scanner;

public class Motus extends Mots
{
    public Motus ()
    {
        super();
    }

    protected void verifierFinPartie()
    {

    }

    @Override
    public void notifyObserver() {

    }

    protected void jouerTour()
    {
        // TODO Julien
        // TODO intégrer la fonctionnalité > passer du mode console au mode graphique
        Scanner sc = new Scanner(System.in);
    }
}
