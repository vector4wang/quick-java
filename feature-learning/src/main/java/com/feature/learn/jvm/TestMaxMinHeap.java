package com.feature.learn.jvm;

/**
 * 堆分配参数
 * 设置-Xmx 和 -Xms 来修改默认的最大堆与初始化堆
 *
 *    maxMemory:3641M
 *    freeMemory:1932M
 *	  totalMemory:1963M
 * totalMemory 就是初始化堆大小，它的意思是一开始限定堆大小为多少，如果不够则可以扩充，但必须小于最大堆大小。
 */
public class TestMaxMinHeap {

	private static final int M = 1024 * 1024;

	public static void main(String[] args) {
		/**
		 *   maxMemory:18M
		 *	 freeMemory:4M
		 *	 totalMemory:5M
		 *	 因为b[]变为
		 *	 maxMemory:18M
		 *	 freeMemory:2M
		 *	 totalMemory:5M
		 *
		 *	 消耗2M
		 */
		byte b[] = new byte[2 * M];
//		byte b[] = new byte[6 * M];
//		byte b[] = new byte[21 * M]; Java heap space

        System.out.println("maxMemory:" + ( Runtime.getRuntime().maxMemory()/1024/1024) + "M");
        System.out.println("freeMemory:" + (Runtime.getRuntime().freeMemory()/1024/1024) + "M");
        System.out.println("totalMemory:" + (Runtime.getRuntime().totalMemory()/1024/1024) + "M");
    }
}