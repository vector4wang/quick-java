package com.feature.learn.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 构造了一个简单的类加载器，它可以加载与自己在同一个路径下的Class文件。
 * 然后使用这个类加载器去加载全限定名是temp.ClassLoaderTest的类，
 * 并实例化了这个类的对象。从第一行输出可以看出，这个对象确实是temp.ClassLoaderTest类的一个实例，
 * 我们打印了一下对象obj的类加载器和ClassLoaderTest的类加载器，发现确实是不同的两个不同的类加载器，
 * 最后输出表明在做instanceof检查时出现了false，这是因为这时虚拟机中有两个temp.ClassLoaderTest类，
 * 一个是系统应用程序类加载器加载的，另一个是自定义的类加载器加载的，这两个类虽然来自同一个Class文件，
 * 但是加载它们的类加载器不同，导致类型检查时结果是false。
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = loader.loadClass("com.feature.learn.classloader.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(obj instanceof com.feature.learn.classloader.ClassLoaderTest);
    }
}