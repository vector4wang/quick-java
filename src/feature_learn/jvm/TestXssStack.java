package feature_learn.jvm;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/4 0004
 * Time: 19:58
 * Description: 指定 线程栈 大小，如:-Xss128k，一般来说，如果程序有大规模的递归行为，可以设置到 512K-1M。
 */
public class TestXssStack {
	public static int count = 0;

	public static void func() {
		count++;
		func();
	}

	public static void main(String[] args) {
		try {
			func();
		} catch (Throwable e) {
			System.out.println("count:" + count);
		}
	}
}
