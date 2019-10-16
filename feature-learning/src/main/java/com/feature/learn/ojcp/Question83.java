package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 10:18
 *
 */
public class Question83 {
	/**
	 * byte -> short -> int -> long -> float -> double
	 * @param args
	 */
	public static void main(String[] args) {
		int iVar = 100;
		float fVar = 100.100f;
		double dVar = 123;


		//		iVar = fVar;
		fVar = iVar;
		dVar = fVar;
//		fVar = dVar;
		dVar = iVar;
//		iVar = dVar;
	}
}
