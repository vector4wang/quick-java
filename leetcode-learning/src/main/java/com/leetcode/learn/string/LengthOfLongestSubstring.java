package com.leetcode.learn.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author wangxc
 * @date: 2019-08-09 07:58
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int i = 0, j = 0;

        Set<Character> temp = new HashSet<>();
        while (i < len && j < len) {
            if (temp.contains(s.charAt(j))) {
                temp.remove(s.charAt(i++));
            } else {
                temp.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
        }

        return max;
    }
}
