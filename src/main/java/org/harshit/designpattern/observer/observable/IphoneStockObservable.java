package org.harshit.designpattern.observer.observable;

import java.util.HashSet;
import java.util.Set;

import org.harshit.designpattern.observer.observer.NotificationObserver;

public class IphoneStockObservable implements ObservableInterface {

    private final Set<NotificationObserver> observers;
    private int stockQuantity;

    public IphoneStockObservable() {
        this.observers = new HashSet<>();
        this.stockQuantity = 0;
    }

    @Override
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
        System.out.println(observer + " subscribed");
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
        System.out.println("Unsubscribed " + observer);
    }

    @Override
    public void notifyObservers() {
        for (NotificationObserver observer : observers) {
            observer.update();
        }
    }

    public void setData(int stockQuantity) {
        if (this.stockQuantity == 0) {
            notifyObservers();
        }
        this.stockQuantity = stockQuantity;
    }
}