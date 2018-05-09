package design.patterns.dependency_inversion_principle.after;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class Cat implements IAnimalAction {
    @Override
    public void eat() {
        System.out.println("爱吃鱼");
    }

    @Override
    public void run() {
        System.out.println("四条腿跑");
    }
}
