package eapli.mymoney.domain;

/**
 * Created by brunodevesa on 14/05/15.
 */
public interface Observer {
    void notify(Observable observable, Object object );
}
