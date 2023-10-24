package org.harshit.designpattern.observer.observable;

import org.harshit.designpattern.observer.observer.NotificationObserver;

public interface ObservableInterface {

    void addObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    void notifyObservers();

}