package com.example.headfirst.observer.role;

/**
 */
public interface ISubject {

    void subscribe(IObserver observer);

    void unSubscribe(IObserver observer);

    void update();

}
