package com.excel.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vector
 * @Data 2018/8/2 0002
 * @Description TODO
 */
public class TestMain2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);

		List[] lists =  splitList(list, 6);

		for (List list1 : lists) {
			System.out.println(list1.size());
		}
	}

}
