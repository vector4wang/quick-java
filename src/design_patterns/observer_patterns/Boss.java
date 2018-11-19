package design_patterns.observer_patterns;

/**
 * @author vector
 * @date: 2018/11/19 0019 10:31
 */
public class Boss extends Subject {

    @Override
    void doNotify(String status) {
        for (Observer observer : observers) {
            observer.doUpdate(status);
        }
    }
}
