package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-14 18:38
 *
 */
public class Question23 {
	/**
	 * null unix linux Solarios
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String arr[] = new String[4];
			arr[1] = "unix";
			arr[2] = "linux";
			arr[3] = "Solarios";
			for (String s : arr) {
				System.out.print(s + " ");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
