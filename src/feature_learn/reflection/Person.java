package feature_learn.reflection;

import java.lang.reflect.Constructor;

class Person {

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "[" + this.name + "  " + this.age + "]";
    }

    private String name;
    private int age;
}

class hello {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("feature_learn.reflection.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person per1 = null;
        Person per2 = null;
        Person per3 = null;
        Person per4 = null;
        //取得全部的构造函数
        Constructor<?> cons[] = demo.getConstructors();
        try {
            per1 = (Person) cons[0].newInstance();
            per2 = (Person) cons[1].newInstance("Rollen");
            per3 = (Person) cons[2].newInstance(20);
            per4 = (Person) cons[3].newInstance("Rollen", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);
    }
}
