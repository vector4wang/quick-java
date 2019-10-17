package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 11:38
 *
 */
public class Question105 {
	public static void main(String[] args) {
		System.out.println(maskCC("1234-5678-9101-1121"));
	}
	public static String maskCC(String creditCard) {
		String x = "XXXX-XXXX-XXXX-";
		StringBuilder sb = new StringBuilder(creditCard);
		sb.insert(0, x);
		System.out.println(sb);
		return sb.toString();

	}
}
