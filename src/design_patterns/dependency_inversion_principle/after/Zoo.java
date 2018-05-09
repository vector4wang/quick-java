package design_patterns.dependency_inversion_principle.after;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class Zoo {

    private IAnimalAction animalAction;

    public Zoo(IAnimalAction animalAction) {
        this.animalAction = animalAction;
    }

    public void AnimalEat() {
        animalAction.eat();
    }

    public void AnimalRun() {
        animalAction.run();
    }


}
