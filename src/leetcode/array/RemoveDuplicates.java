package leetcode.array;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/12 0012
 * Time: 9:45
 * Description: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 *
 * 从排序数组中删除重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * eg:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int i = removeDuplicates(nums);
		System.out.println(i);

	}

	/**
	 * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。

	 * 当我们遇到 nums[j] \neq nums[i]nums[j]≠nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。
	 * 然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}

		return i + 1;
	}


}
