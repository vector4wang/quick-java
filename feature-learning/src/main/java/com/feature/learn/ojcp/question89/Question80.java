package com.feature.learn.ojcp.question89;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 23:31
 *
 */
public class Question80 {
	public static void main(String[] args) {

	}
}

interface Downloadable {
	public void download();
}

interface Readable extends Downloadable {
	public void readBook();
}

abstract class Book implements Readable {
	public void readBook() {
		System.out.println("Read Book");
	}
}

class EBook extends Book {
	@Override
	public void readBook() {
		System.out.println("Read EBook");
	}

	@Override
	public void download() {
	}
}