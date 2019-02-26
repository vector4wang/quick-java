package com.design.patterns.dependency_inversion_principle.before;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class Zoo {
    private Cat cat;
    private Dog dog;
    private String name;

    public Zoo(String name) {
        this.cat = new Cat();
        this.dog = new Dog();
        this.name = name;
    }

    public void AnimalEat() {
        if (name.equals("cat")) {
            cat.eat();
        } else {
            dog.eat();
        }
    }

    public void AnimalRun() {
        if (name.equals("dog")) {
            dog.run();
        } else {
            cat.run();
        }

    }
}
