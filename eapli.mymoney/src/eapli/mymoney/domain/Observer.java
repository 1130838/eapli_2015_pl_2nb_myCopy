package eapli.mymoney.domain;

/**
 * Created by brunodevesa on 14/05/15.
 */
// to be an observer, how must be my API ? What do i want as an observer ?
public interface Observer {

    public void subscribe(Observable observable);
    public void unsubscribe (Observable observable);
    public void update();



}
