package feature.learn.generic_paradigm;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class CalTest<A,B> {
    public final A first;
    public final B second;

    public CalTest(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "CalTest{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
