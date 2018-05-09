package design_patterns.mediator_pattern

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/10/17
 * Time: 20:11
 * Description: 第二步：定义抽象Colleague
 */
public class Colleague {

    protected String name;
    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }


}
