package design_patterns.mediator_pattern

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/10/17
 * Time: 20:12
 * Description: 第三步：定义具体Colleagueclass
 */
public class ColleagueA extends Colleague {

    public ColleagueA(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void getMessage(String message) {
        System.out.println("同事A" + name + "获得信息" + message);
    }

    public void contact(String message) {
        mediator.contract(message,this);
    }

}
