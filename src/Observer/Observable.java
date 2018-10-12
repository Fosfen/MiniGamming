package Observer;

public interface Observable
{
    void addObserver (Observer obs);
    void removeObserver();
    void notifyObserver ();
}
