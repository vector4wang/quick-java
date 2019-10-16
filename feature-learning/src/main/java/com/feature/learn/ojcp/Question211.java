package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-16 00:13
 *
 */
public class Question211 {
	public static void main(String[] args) {
	}
}

interface Readable {
	public void readBook();

	public void setBookMark();
}

abstract class Book implements Readable {    // line n1
	public void readBook() {
	}
	// line n2
}

abstract  class EBook extends Book {                    // line n3
	public void readBook() {
	}
	// line n4
}