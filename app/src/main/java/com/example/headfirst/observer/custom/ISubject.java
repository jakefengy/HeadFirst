package com.example.headfirst.observer.custom;

/**
 */
public interface ISubject {

    void subscribe(IObserver observer);

    void unSubscribe(IObserver observer);

    void update();

}
