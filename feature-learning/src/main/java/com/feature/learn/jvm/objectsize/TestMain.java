package com.feature.learn.jvm.objectsize;

/**
 * @author vector
 * @date: 2019/9/6 0006 9:37
 */
public class TestMain {
    public static void main(String[] args) {
        byte b = 1;
        Byte bb = 1;

        char c = 1;
        Character bc = 1;

        short s = 1;
        Short bs = 1;

        int i = 1;
        Integer bi = 1;

        double d = 1;
        Double bd = 1D;

        float f = 1;
        Float bf = 1F;

        long l = 1;
        Long bl = 1L;

        boolean bn = false;
        Boolean bbn = false;


        System.out.println(SizeOfObject.sizeOf(b));
        System.out.println(SizeOfObject.sizeOf(bb));

        System.out.println(Byte.SIZE);
        System.out.println(Short.SIZE);

    }
}
