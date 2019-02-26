package com.feature.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/5/31 0031
 * Time: 9:38
 * Description: https://www.cnblogs.com/rollenholt/archive/2011/09/02/2163758.html
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("feature_learn.reflection.Person");

            /**
             * person 对应有四个构造器，数组长度就是4 为什么是倒叙而不是正序？
             * Constructor<?>[] constructors = aClass.getConstructors();
             * Person person1 = (Person) constructors[3].newInstance();
             * Person person2 = (Person) constructors[2].newInstance("vector");
             * Person person3 = (Person) constructors[1].newInstance(18);
             * Person person4 = (Person) constructors[0].newInstance("vector",18);
             * 不同机器返回的顺序可能不一样
             */
            Constructor<?> declaredConstructor1 = aClass.getDeclaredConstructor();
            Constructor<?> declaredConstructor2 = aClass.getDeclaredConstructor(String.class);
            Constructor<?> declaredConstructor3 = aClass.getDeclaredConstructor(int.class);
            Constructor<?> declaredConstructor4 = aClass.getDeclaredConstructor(String.class, int.class);

            Person person1 = (Person) declaredConstructor1.newInstance();
            Person person2 = (Person) declaredConstructor2.newInstance("vector");
            Person person3 = (Person) declaredConstructor3.newInstance(18);
            Person person4 = (Person) declaredConstructor4.newInstance("vector", 18);

            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person3);
            System.out.println(person4);


            System.out.println("==========================================================");

            Class<?> aClass1 = Class.forName("feature_learn.reflection.Person");
            Class<?>[] interfaces = aClass1.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                System.out.println("实现的接口: " + anInterface.getName());
            }

            System.out.println("==========================================================");

            Class<?> superclass = aClass1.getSuperclass();
            System.out.println("继承的父类: " + superclass.getName());

            System.out.println("==========================================================");


            Constructor<?>[] constructors = aClass1.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("构造方法: " + constructor);
            }

            System.out.println("==========================================================");

            Field[] declaredFields = aClass1.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                int modifiers = declaredField.getModifiers();
                String moStr = Modifier.toString(modifiers);

                Class<?> type = declaredField.getType();
                System.out.println("自身的属性： " + moStr + " " + type.getName() + " "
                        + declaredField.getName() + ";");
            }

            declaredFields = aClass1.getFields();

            for (Field declaredField : declaredFields) {
                int modifiers = declaredField.getModifiers();
                String moStr = Modifier.toString(modifiers);

                Class<?> type = declaredField.getType();
                //TODO 为什么没有打印继承的属性

                System.out.println("实现或继承的属性: " + moStr + " " + type.getName() + " "
                        + declaredField.getName() + ";");
            }

            Method talkMethod = aClass1.getMethod("talk", String.class, String.class);
            talkMethod.invoke(aClass1.newInstance(),"张三","今天天气不错");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
