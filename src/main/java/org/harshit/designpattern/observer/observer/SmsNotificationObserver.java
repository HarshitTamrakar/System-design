package org.harshit.designpattern.observer.observer;

import org.harshit.designpattern.observer.observable.ObservableInterface;

public class SmsNotificationObserver implements NotificationObserver {

    private final String mobileNumber;
    private final ObservableInterface observable;

    public SmsNotificationObserver(String mobileNumber, ObservableInterface observable) {
        this.mobileNumber = mobileNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Sending message to " + mobileNumber);
    }

    @Override
    public void unsubscribe() {
        observable.removeObserver(this);
    }

    @Override
    public String toString() {
        return "SmsNotificationObserver{" +
            "mobileNumber='" + mobileNumber + '\'' +
            '}';
    }
}