package com.feature.learn.ojcp.question89;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 23:25
 *
 */
public class Question78 {
	public static void main(String[] args) {
		int wd = 0;
		String days[] = {"sun", "mon", "wed", "sat"};
		for (String day : days) {
			switch (day) {
				case "sat":
				case "sun":
					wd -= 1;
					break;
				case "mon":
					wd++;
				case "wed":
					wd += 2;
			}
		}
		System.out.println(wd);
	}
}
