package org.harshit.designpattern.observer;

import org.harshit.designpattern.observer.observable.IphoneStockObservable;
import org.harshit.designpattern.observer.observer.EmailNotificationObserver;
import org.harshit.designpattern.observer.observer.NotificationObserver;
import org.harshit.designpattern.observer.observer.SmsNotificationObserver;

public class Main {

    // Observer design pattern states, when Observable state is changed or updated then all its
    // Observers must be notified, best example for this design pattern is to implement notifyMe
    // on product page of ecommerce websites, when product stock is updated from 0 to some value
    // then all the subscribed users must be notified.

    public static void main(String[] args) {
        IphoneStockObservable iphoneStockObservable = new IphoneStockObservable();
        NotificationObserver user1 =
            new EmailNotificationObserver("xyz@gmail.com", iphoneStockObservable);
        NotificationObserver user2 =
            new SmsNotificationObserver("9876543210", iphoneStockObservable);
        iphoneStockObservable.addObserver(user1);
        iphoneStockObservable.addObserver(user2);

        iphoneStockObservable.setData(10);
        iphoneStockObservable.setData(0);
        user1.unsubscribe();
        iphoneStockObservable.setData(100);

    }
}