package algorithm.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 * 二分法查找示例
 */
public class Arithmetic {
    public static <T extends Comparable<? super T>> int BinarySearch(List<T> array, int start, int end, T key) {
        int low;
        int high;
        int guess;

        if (array == null || start > end || start > array.size() - 1 || end < 0) {
            return -1;
        }

        start = start < 0 ? 0 : start;
        low = start - 1;

        end = end > array.size() - 1 ? array.size() - 1 : end;
        high = end + 1;


        while (high - low > 1) {
            guess = ((high - low) >> 1) + low;

            if (array.get(guess).compareTo(key) < 0)
                low = guess;
            else
                high = guess;
        }

        if (high == end + 1) {
            return ~(end + 1);
        } else if (array.get(high).compareTo(key) == 0) {
            return high;
        } else {
            return ~high;
        }
    }

    public static <T extends Comparable<? super T>> int BinarySearch(T[] array, int start, int end, T key) {
        List<T> stooges = Arrays.asList(array);
        return Arithmetic.BinarySearch(stooges, start, end, key);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ArrayList<Integer> a = new ArrayList<>();

        Float[] b = new Float[100];


        for (int i = 0; i < 100; i++) {
            a.add(i);
            b[i] = (float) i;

        }
        System.out.println("" + Arithmetic.BinarySearch(a, 0, 1000, 200));
        System.out.println("" + Arithmetic.BinarySearch(b, 0, 100, 12.f));

    }
}
