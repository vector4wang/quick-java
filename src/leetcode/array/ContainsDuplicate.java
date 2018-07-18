package leetcode.array;

import java.util.Arrays;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/17 0017
 * Time: 16:56
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		//		int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		int nums[] = {1, 2, 3, 4};
		System.out.println(containsDuplicate(nums));
	}

	/**
	 * 使用异或操作，还可以
	 * @param nums
	 * @return
	 */
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 1) {
			return false;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if ((nums[i] ^ nums[i + 1]) == 0) {
				return true;
			}
		}
		return false;
	}
}
