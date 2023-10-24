package org.harshit.designpattern.observer.observer;

import org.harshit.designpattern.observer.observable.ObservableInterface;

public class EmailNotificationObserver implements NotificationObserver {

    private final ObservableInterface observable;
    private final String email;

    public EmailNotificationObserver(String email, ObservableInterface observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Sending email to: " + email);
    }

    @Override
    public void unsubscribe() {
        observable.removeObserver(this);
    }

    @Override
    public String toString() {
        return "EmailNotificationObserver{" +
            "email='" + email + '\'' +
            '}';
    }
}