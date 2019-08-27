package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wangxc
 * @date: 2019-08-17 19:50
 *
 */
public class SortedExample3 {
	public static void main (String[] args) {
		Set<Integer> list = new HashSet<>(Arrays.asList(2, 1, 3));
		Object[] objects = list.stream().sorted().toArray();
		System.out.println(Arrays.toString(objects));
	}
}
