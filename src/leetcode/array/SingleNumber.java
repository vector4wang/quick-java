package leetcode.array;

import java.util.Arrays;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/17 0017
 * Time: 17:03
 * Description:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {

	public static void main(String[] args) {
		/**
		 * 输入: [4,1,2,1,2]
		 * 输出: 4
		 */
//		int nums[] = {4, 1, 2, 1, 2};
				int nums[] = {2, 2, 1};
		System.out.println(singleNumber(nums));
	}

	/**
	 * 9ms
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] != nums[i + 1]) {
					return nums[i];
				}
			}

			if (i == nums.length-1) {
				if (nums[i - 1] != nums[i]) {
					return nums[i];
				}
			}
			if (nums[i] != nums[i + 1] && nums[i - 1] != nums[i]) {
				return nums[i];
			}
		}
		return 0;
	}

	/**
	 * 1ms
	 *
	 * 异或操作 各个位置，相同为0不同为1
	 * 想知道，写出这样的方法的人是怎样的人，为什么会如此犀利！！！
	 * @param nums
	 * @return
	 */
	public static int singleNumberquick(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num ^= nums[i];
		}
		return num;
	}
}
