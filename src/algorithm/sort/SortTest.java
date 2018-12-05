package algorithm.sort;

/**
 * @author vector
 * @date: 2018/12/4 0004 10:07
 * http://blog.damonare.cn/2016/12/20/%E5%8D%81%E5%A4%A7%E7%BB%8F%E5%85%B8%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%EF%BC%88javascript%E6%8F%8F%E8%BF%B0%EF%BC%89/
 * https://mp.weixin.qq.com/s/b1T4yFGf98z4Zqe0cMrbrg
 */
public class SortTest {
	public static void main(String[] args) {
		int arr[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		long s = System.nanoTime();
		//        bubbleSort(arr);
		//        selectionSort(arr);
		insertionSort(arr);
		long e = System.nanoTime();
		print(arr, (e - s) / 1000_000);

	}

	/**
	 * 插入排序
	 * 从第一个元素开始，该元素可以认为已经被排序；
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
	 * 将新元素插入到该位置后；
	 * 重复步骤2~5。
	 *
	 * 最好手动操作下
	 * @param arr
	 */
	private static void insertionSort(int[] arr) {
		int len = arr.length;
		int preIndex, current;
		for (int i = 1; i < len; i++) {
			preIndex = i - 1;
			current = arr[i];
			while (preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
		}
	}

	/**
	 * 选择排序
	 * 初始状态：无序区为R[1..n]，有序区为空；
	 * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
	 * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
	 * n-1趟结束，数组有序化了。
	 * @param arr
	 */
	private static void selectionSort(int[] arr) {
		int minIndex, temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	/**
	 * 冒泡排序
	 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
	 * 针对所有的元素重复以上的步骤，除了最后一个；
	 * 重复步骤1~3，直到排序完成。
	 *
	 * @param
	 *
	 *
	 */
	private static void bubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}


	private static void print(int[] newArr, long millisecond) {
		for (int i : newArr) {
			System.out.print(i + ", ");
		}
		System.out.print("耗时: " + millisecond);
		System.out.println();
	}
}
