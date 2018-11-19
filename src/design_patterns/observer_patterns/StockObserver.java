package design_patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:07
 */
public class StockObserver extends Observer {
    private String name;
    private Subject sub;

    public StockObserver(String name, Subject sub) {
        super(name,sub);
    }

    @Override
    public void doUpdate(String status) {
        System.out.println(status+" " + name + "关闭股票行情，继续工作！");
    }
}
