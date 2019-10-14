package com.feature.learn.ojcp;

import com.feature.learn.jvm.objectsize.sample.C;

/**
 * @author vector
 * @date: 2019/10/14 0014 10:48
 */
public class Mid {
    public int findMid(int n1, int n2) {
        return (n1 + n2) / 2;
    }
}

class Calc extends Mid {
    public static void main(String[] args) {
        int n1 = 22, n2 = 2;
        Calc c = new Calc();
        int n3 = c.findMid(n1, n2);

//        int n3 = super.findMid(n1, n3); // cant be referenced by static context

//        Calc c = new Mid();
//        int n3 = c.findMid(n1, n2);

//        Mid mi = new Calc();
//        int n3 = mi.findMid(n1, n2);

//        int n3 = Calc.findMid(n1, n2);// cant be referenced by static context

        System.out.println(n3);
    }
}
