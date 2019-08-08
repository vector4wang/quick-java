package com.leetcode.learn.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author vector
 * @date: 2019/8/8 0008 13:40
 */
public class TwoSumIndex {

    public static void main(String[] args) {
        int nums[] = new int[] {2, 7, 11, 15};
        int target = 9;
//        int[] ints = twoSum(nums, target);
        int[] ints = twoSum2(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 执行用时 : 53 ms , 在所有 Java 提交中击败了 35.73% 的用户
     * 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 71.16% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 63.27% 的用户
     * 内存消耗 : 39.1 MB , 在所有 Java 提交中击败了 47.54% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }


}
