package Model;

import Observer.Observable;
import Observer.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable
{
    // Attributs
    protected boolean partieTerminee; // true si la partie est terminée
    protected boolean partieGagnee; // true si la partie est gagnée

    // Méthodes générales à tous les jeux
    public void lancerPartie()
    {
        this.jouerTour();
    }
    protected abstract void jouerTour();
    protected abstract void verifierFinPartie();

    public AbstractModel()
    {
        this.partieTerminee = false;
        this.partieGagnee = false;
    }

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
}
