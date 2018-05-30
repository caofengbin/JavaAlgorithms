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

    public int minSubArrayLen(int s, int[] nums) {
        // 采用滑动窗口法，[leftWindow,rightWindow]左闭右闭区间上，均为滑动窗口的取值范围
        int leftWindow = 0;
        int rightWindow = 0;
        int result = nums.length + 1;
        int sum = nums[rightWindow];
        while (rightWindow <= nums.length - 1 && leftWindow <= rightWindow) {
            if (sum < s && rightWindow + 1 <= nums.length - 1) {
                // 滑动窗口中的元素和小于目标值
                rightWindow++;
                sum += nums[rightWindow];
            } else {
                // 滑动窗口中的元素和大于等于目标值
                result = Math.min(result, rightWindow - leftWindow + 1);
                sum -= nums[leftWindow];
                leftWindow++;
            }
        }

        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
    }
}
