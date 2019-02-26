package com.design.patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:21
 */
public abstract class Observer {
    protected String name;
    protected Subject sub;

    public Observer(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }

    public abstract void doUpdate(String status);
}
