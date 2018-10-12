package Model;

import Observer.Observable;
import Observer.Observer;

import java.util.ArrayList;

public abstract class AbstractModel implements Observable
{
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs)
    {
        this.observers.add(obs);
    }

    public void removeObserver ()
    {
        this.observers = new ArrayList<>();
    }

    public void notifyObserver ()
    {
        for (Observer obs : this.observers)
        {
            obs.update();
        }
    }
}
