package com.design.patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:06
 */
public class Secretary extends Subject {

    public void doNotify(String status) {
        for (Observer observer : observers) {
            observer.doUpdate(status);
        }
    }
}
