package leetcode.array;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/18 0018
 * Time: 17:02
 * Description:
 *
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class Intersect {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};

		int[] intersect = intersect(nums1, nums2);
		for (int i : intersect) {
			System.out.println(i);
		}
	}

	// TODO: 2018/7/18 0018  
	public static int[] intersect(int[] nums1, int[] nums2) {
		int[] result = {};


		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				
			}
		}
		return result;
	}
}
