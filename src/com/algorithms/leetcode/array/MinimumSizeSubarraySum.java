package com.algorithms.leetcode.array;

/**
 * leetcode 209 links:https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * <p>
 * description:
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal le
 */
public class MinimumSizeSubarraySum {

    /**
     * 思路分析：典型的滑动窗口问题思路来求解该问题即可
     *
     * @param s    目标值target
     * @param nums 待处理的数组结构nums
     * @return 最短的长度
     */
    public int minSubArrayLen(int s, int[] nums) {
        // 要点1：[leftWindow,rightWindow]左闭右闭区间上，均为滑动窗口的取值范围，注意该初值的赋值
        // 初始情况下左0，右-1，表示当前的窗口内为空
        int leftWindow = 0;
        int rightWindow = -1;
        int result = nums.length + 1;
        int sum = 0;

        // 要点2：滑动窗口的循环遍历条件
        // leftWindow < nums.length，即只要左窗口还能取值，说明整个窗口还有值
        while (leftWindow < nums.length) {
            if (sum < s && rightWindow + 1 < nums.length) {
                // 当前滑动窗口内元素之和小于目标值，滑动窗口可以继续扩大
                rightWindow++;
                sum += nums[rightWindow];
            } else {
                // 当前滑动窗口内元素之和大于目标值，滑动窗口需要缩小范围
                sum -= nums[leftWindow];
                leftWindow++;
            }

            // 要点3：每一轮循环完成，如果sum >= s，就判断一下可否更新最小的长度
            if (sum >= s) {
                result = Math.min(result, rightWindow - leftWindow + 1);
            }
        }

        return result == nums.length + 1 ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
    }
}
