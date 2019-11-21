package com.feature.learn.ojcp.enthuware.test1;

import java.io.FileNotFoundException;

/**
 *
 * @author wangxc
 * @date: 2019-10-19 09:37
 *
 */
public class Question15 {
}

class Test1 {
	public void print() throws FileNotFoundException {
	}
}

class Test2 extends Test1 {
	@Override
	public void print() throws FileNotFoundException {
		super.print();
	}
}
