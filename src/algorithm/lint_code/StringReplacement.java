package algorithm.lint_code;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 * 字符串置换: http://www.lintcode.com/zh-cn/problem/string-permutation/
 */
public class StringReplacement {
    public static void main(String[] args) {
        System.out.println(Permutation("abca", "cba"));

    }


    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public static boolean Permutation(String A, String B) {
        char[] chars = A.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars.length - 1 - i;
            if (i >= j) {
                break;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        String newA = new String(chars);
        System.out.println(newA);
        return newA.equals(B);
    }
}
