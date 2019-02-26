package com.feature.learn.jvm;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/4 0004
 * Time: 19:35
 * Description:
 *    -Xmn：设置 新生代 大小
 *    -NewRatio：设置 新生代 和 老年代 的比率
 *    -SurvivorRatio：设置新生代中 Eden space 和 Survivor space 的大小
 *
 *   1、 -Xmn1m -Xms20m -Xmx20m -XX:+PrintGCDetails
 *    [GC (Allocation Failure) [PSYoungGen: 512K->488K(1024K)] 512K->496K(19968K), 0.0005387 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *	 [GC (Allocation Failure) [PSYoungGen: 1000K->504K(1024K)] 1008K->640K(19968K), 0.0015850 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *	 Heap
 *	 PSYoungGen      total 1024K, used 611K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
 *	 eden space 512K, 20% used [0x00000000ffe80000,0x00000000ffe9ac38,0x00000000fff00000)
 *	 from space 512K, 98% used [0x00000000fff80000,0x00000000ffffe010,0x0000000100000000)
 *	 to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *	 ParOldGen       total 18944K, used 10376K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
 *	 object space 18944K, 54% used [0x00000000fec00000,0x00000000ff6220a0,0x00000000ffe80000)
 *	 Metaspace       used 3311K, capacity 4494K, committed 4864K, reserved 1056768K
 *	 class space    used 363K, capacity 386K, committed 512K, reserved 1048576K
 *	 Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size of 1536k will be used.
 */
public class TestNewSpace {
	private static final int M = 1024 * 1024;

	public static void main(String[] args) {

		byte[] b = null;

		for (int i = 0; i < 10; ++i) {
			b = new byte[1 * M];
		}
	}
}
