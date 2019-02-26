package com.design.patterns.mediator_pattern;

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/10/17
 * Time: 20:14
 * Description:
 */
public class ColleagueB extends Colleague {
    public ColleagueB(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void getMessage(String message) {
        System.out.println("同事B" + name + "获得信息" + message);
    }

    public void contact(String message) {
        mediator.contract(message,this);
    }
}
