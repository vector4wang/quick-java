package com.feature.learn.jvm;

/**
 * @author vector
 * @date: 2019/10/11 0011 17:34
 */
public class ObjectReference {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "wxc";
        System.out.println(p.name);
        change(p);
        System.out.println(p.name);
    }

    private static void change(Person p) {
        //p = new Person("wdc");
        p.name = "wdc";
    }
}

class Person{
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
