package Model;

import Observer.Observer;

public class Motus extends Mots
{
    public Motus ()
    {
        super();
    }

    @Override
    protected void bonChoix()
    {

    }

    @Override
    protected void mauvaisChoix()
    {

    }

    public void notifyObserver()
    {
        for (Observer obs : this.observers)
        {
            obs.update();
        }
    }
}
