package leetcode.array;

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
		int nums[] = {4, 1, 2, 1, 2};
		//		int nums[] = {2, 2, 1};
		System.out.println(singleNumberquick(nums));
	}

	public static int singleNumber(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					if (nums[i] == nums[j]) {
						count++;
					}
				}
			}
			if (count == 0) {
				return nums[i];
			} else {
				count = 0;
			}
		}
		return 0;
	}

	public static int singleNumberquick(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num ^= nums[i];
		}
		return num;
	}
}
