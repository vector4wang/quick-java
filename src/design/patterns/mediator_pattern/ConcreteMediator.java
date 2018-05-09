package design.patterns.Mediator

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/10/17
 * Time: 20:15
 * Description: 第四步：定义具体中介者ConcreteMediator,具体中介者通过协调各同事对象实现协作行为，了解并维护它的各个同事。
 */
public class ConcreteMediator extends Mediator {

    ColleagueA collA;
    ColleagueB collB;

    public ColleagueA getCollA() {
        return collA;
    }

    public void setCollA(ColleagueA collA) {
        this.collA = collA;
    }

    public ColleagueB getCollB() {
        return collB;
    }

    public void setCollB(ColleagueB collB) {
        this.collB = collB;
    }

    public void contract(String content, Colleague colleague) {
        if (colleague == collA) {
            collB.getMessage(content);
        } else {
            collA.getMessage(content);
        }
    }
}
