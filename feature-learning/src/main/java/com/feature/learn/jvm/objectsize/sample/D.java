package com.feature.learn.jvm.objectsize.sample;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wangxc
 * @date: 2019-09-17 00:22
 *
 */
public class D {
	private Map<String, String> map;

	public D() {
		map = new HashMap<>();
		map.put("A", "A1");
		map.put("V", "A2");
		map.put("X", "A3");
		map.put("D", "A4");
	}

	public static void main(String[] args) throws InterruptedException {
		D d = new D();
		Thread.sleep(1000 * 1000);
		System.out.println(d);
	}
}
