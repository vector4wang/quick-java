package com.design.patterns.observer_patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:29
 */
public abstract class Subject {

    List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    abstract void doNotify(String status);
}
