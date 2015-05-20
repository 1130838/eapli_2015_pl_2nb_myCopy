package eapli.mymoney.domain;



/**
 * Created by brunodevesa on 14/05/15.
 */
// to be something that is observed, how must be my API ? What do i want as a object of interest  ?
public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
