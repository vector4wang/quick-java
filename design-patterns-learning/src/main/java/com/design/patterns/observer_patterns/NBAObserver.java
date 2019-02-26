package com.design.patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:23
 */
public class NBAObserver extends Observer {

    private String name;
    private Subject sub;

    public NBAObserver(String name, Subject sub) {
        super(name, sub);
    }

    @Override
    public void doUpdate(String status) {
        System.out.println(status+" " + name + "关闭NBA直播，继续工作！");
    }
}
