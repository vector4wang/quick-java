package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 22:17
 *
 */
public class Question163 {
	public static void main(String[] args) {
		StringBuffer test = new StringBuffer("test");
		System.out.println("hello " + test);

		System.out.println( 28 + 5 <= 4 +29 );
		System.out.println( ( 28 + 5 ) <= ( 4 + 29 ));

		int[] xx = null;
		for (int ii : xx) {
			System.out.println(ii);
		}
	}
}
