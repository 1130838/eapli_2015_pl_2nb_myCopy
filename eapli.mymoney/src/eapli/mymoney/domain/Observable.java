package eapli.mymoney.domain;

import java.util.Observer;

/**
 * Created by brunodevesa on 14/05/15.
 */
public interface Observable {


    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
