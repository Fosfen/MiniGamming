package Model;

import Observer.Observable;
import Observer.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable
{
    // Méthodes générales à tous les jeux
    //public abstract void lancerPartie(); TODO

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

    public abstract void notifyObserver();
}
