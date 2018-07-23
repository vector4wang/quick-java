package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/18 0018
 * Time: 17:02
 * Description:
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class Intersect {
	public static void main(String[] args) {
		int[] nums1 = {2,1,3,1,3};
		int[] nums2 = {2,2,3};

		int[] intersect = intersect(nums1, nums2);
		for (int i : intersect) {
			System.out.println(i);
		}
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int x = 0;
		int y = 0;
		List<Integer> result = new ArrayList<>();
		while (x < nums1.length && y < nums2.length) {

			if (nums1[x] > nums2[y]) {
				y++;
			} else if (nums1[x] < nums2[y]) {
				x++;
			} else {
				result.add(nums1[x]);
				x++;
				y++;
			}
		}

		int[] tmp = new int[result.size()];
		for (int k = 0; k < tmp.length; k++) {
			tmp[k] = result.get(k);
		}
		return tmp;
	}
}
