package feature_learn.jvm;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/4 0004
 * Time: 17:26
 * Description: 使用PrintGCDetail  -XX:+PrintGCDetails
 *
 * [-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:<file-path>]
 *
 * -XX:+PrintHeapAtGC 打印 GC 前后的堆分配信息
 * -XX:+TraceClassLoading 打印class加载列表
 *
 * Run -> Edit Configurations -> VM options 添加 -XX:+PrintGCDetails
 */
public class TestPrintGcDetails {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			byte[] b = new byte[1*1024*1024];
		}
	}
}

/**
 * [PSYoungGen: 65436K->680K(140800K)] 65444K->688K(314368K), 0.0008217 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 65436K->680K(140800K) : GC之前新生代对象占用的空间为65436K，之后变为688K。新生代这时总的代销为140800K
 * 65444K->688K(314368K), 0.0008217 secs ： 堆空间使用情况从65444K减少到了688K，此时整个堆的大小为314368K，完成垃圾回收操作耗时0.0008217 secs
 * Times: user=0.00 sys=0.00, real=0.00 secs ：GC耗时，用户耗时，系统耗时，真实耗时(真实耗时要>0.0008217,因为系统会使用多线程回收的)
 */


/**
 * Heap
 *	PSYoungGen      total 521216K, used 10404K [0x000000076b580000, 0x000000078b380000, 0x00000007c0000000)
 *	eden space 520192K, 2% used [0x000000076b580000,0x000000076bfa90e0,0x000000078b180000)
 *	from space 1024K, 0% used [0x000000078b280000,0x000000078b280000,0x000000078b380000)
 *	to   space 1024K, 0% used [0x000000078b180000,0x000000078b180000,0x000000078b280000)
 *	ParOldGen       total 173568K, used 676K [0x00000006c2000000, 0x00000006cc980000, 0x000000076b580000)
 *	object space 173568K, 0% used [0x00000006c2000000,0x00000006c20a9070,0x00000006cc980000)
 *	Metaspace       used 3394K, capacity 4494K, committed 4864K, reserved 1056768K
 *	class space    used 374K, capacity 386K, committed 512K, reserved 1048576K
 */

/**
 * url[http://hllvm.group.iteye.com/group/topic/37095]
 *
 * HotSpot VM的GC组老人之一Jon Masamitsu很久之前就写过blog讲解这个：https://blogs.oracle.com/jonthecollector/entry/our_collectors
 *
 *	简单来说，有这么多东西反映了HotSpot VM的开发历史和实现细节。我在写篇东西讲述这部分历史，哪天写完的话在这边也放个链接嗯。
 *
 *	DefNewGeneration是default new generation
 *	ParNewGeneration是parallel new generation
 *
 *	原本HotSpot VM里没有并行GC，当时就只有NewGeneration；后来准备要加入young gen的并行GC，就把原本的NewGeneration改名为DefNewGeneration，然后把新加的并行版叫做ParNewGeneration。
 *
 *	这些XXXGeneration都在HotSpot VM的“分代式GC框架”内。本来HotSpot VM鼓励开发者尽量在这个框架内开发GC，但后来有个开发就是不愿意被这框架憋着，自己硬写了个没有使用已有框架的新并行GC，并拉拢性能测试团队用这个并行GC来跑分，成绩也还不错，于是这个GC就放进HotSpot VM里了。这就是我们现在看到的ParallelScavenge。
 *
 *	（结果就是HotSpot GC组不得不维护两个功能几乎一样、但各种具体细节不同的并行GC。其实是件很头疼的事情嗯）
 *
 *	Scavenge或者叫scavenging GC，其实就是copying GC的另一种叫法而已。HotSpot VM里的GC都是在minor GC收集器里用scavenging的，DefNew、ParNew和ParallelScavenge都是，只不过DefNew是串行的copying GC，而后两者是并行的copying GC。
 *
 *	由此名字就可以知道，“ParallelScavenge”的初衷就是把“scavenge”给并行化。换句话说就是把minor GC并行化。至于full GC，那不是当初关注的重点。
 *
 *	把GC并行化的目的是想提高GC速度，也就是提高吞吐量（throughput）。所以其实ParNew与ParallelScavenge都可叫做Throughput GC。
 *	但是在HotSpot VM的术语里“Throughput GC”通常特指“ParallelScavenge”。
 *
 *	================================
 *
 *	ParallelScavenge和ParNew都是并行GC，主要是并行收集young gen，目的和性能其实都差不多。最明显的区别有下面几点：
 *	1、PS以前是广度优先顺序来遍历对象图的，JDK6的时候改为默认用深度优先顺序遍历，并留有一个UseDepthFirstScavengeOrder参数来选择是用深度还是广度优先。在JDK6u18之后这个参数被去掉，PS变为只用深度优先遍历。ParNew则是一直都只用广度优先顺序来遍历
 *	2、PS完整实现了adaptive size policy，而ParNew及“分代式GC框架”内的其它GC都没有实现完（倒不是不能实现，就是麻烦+没人力资源去做）。所以千万千万别在用ParNew+CMS的组合下用UseAdaptiveSizePolicy，请只在使用UseParallelGC或UseParallelOldGC的时候用它。
 *	3、由于在“分代式GC框架”内，ParNew可以跟CMS搭配使用，而ParallelScavenge不能。当时ParNew GC被从Exact VM移植到HotSpot VM的最大原因就是为了跟CMS搭配使用。
 *	4、在PS成为主要的throughput GC之后，它还实现了针对NUMA的优化；而ParNew一直没有得到NUMA优化的实现。
 *
 *	================================
 *
 *	还有一点要注意：上面说ParallelScavenge并行收集young gen，那old/perm gen呢？
 *
 *	其实最初的ParallelScavenge的目标只是并行收集young gen，而full GC的实际实现还是跟serial GC一样。只不过因为它没有用HotSpot VM的generational GC framework，自己实现了一个CollectedHeap的子类ParallelScavengeHeap，里面都弄了独立的一套接口，而跟HotSpot当时其它几个GC不兼容。其实真的有用的代码大部分就在PSScavenge（＝“ParallelScavenge的Scavenge”）里，也就是负责minor GC的收集器；而负责full GC的收集器叫做PSMarkSweep（＝“ParallelScavenge的MarkSweep”），其实只是在serial GC的核心外面套了层皮而已，骨子里是一样的LISP2算法的mark-compact收集器（别被名字骗了，它并不是一个mark-sweep收集器）。
 *
 *	当启用-XX:+UseParallelGC时，用的就是PSScavenge+PSMarkSweep的组合。
 *	这是名副其实的“ParallelScavenge”——只并行化了“scavenge”。
 *
 *	所以其实非要说对应关系的话，PSScavenge才是真的跟ParNew对等的东西；ParallelScavenge这个名字既指代整套新GC，也可指代其真正卖点的PSScavenge。
 *
 *	不知道后来什么原因导致full GC的并行化并没有在原本的generational GC framework上进行，而只在ParallelScavenge系上进行了。其成果就是使用了LISP2算法的并行版的full GC收集器，名为PSCompact（＝“ParallelScavenge-MarkCompact”），收集整个GC堆。
 *
 *	当启用-XX:+UseParallelOldGC时，用的就是PSScavenge+PSCompact的组合。
 *	此时ParallelScavenge其实已经名不符实了——它不只并行化了“scavenge”（minor GC），也并行化了“mark-compact”（full GC）。
 *
 **/