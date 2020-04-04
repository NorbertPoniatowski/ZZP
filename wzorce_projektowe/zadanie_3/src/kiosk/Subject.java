package kiosk;

import kitchen.Observer;

public interface Subject {
    void register(Observer o);
    void notifyObservers();
}
