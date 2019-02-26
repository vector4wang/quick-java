package com.leetcode.learn.array;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/7/23 0023
 * Time: 15:54
 * Description:
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne {
	public static void main(String[] args) {
		int[] ints = plusOne(new int[]{9,9,9,9});


		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}

	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = digits.length - 1; i >= 0; --i) {
			if (digits[i] < 9) {
				++digits[i];
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		return res;
	}
}
