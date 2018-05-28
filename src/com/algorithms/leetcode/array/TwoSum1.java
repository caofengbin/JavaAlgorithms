package com.algorithms.leetcode.array;

import java.util.HashMap;

/**
 * leetcode 1   hhttps://leetcode.com/problems/two-sum/description/
 * 题目描述：
 * 给定一个无序数组和一个target数字，从数组中找出两个元素使其和相加等于target，
 * 并输出两个元素的下标index
 */
public class TwoSum1 {

    /**
     * 采用hash方法的注意点:
     * (1) 同一个元素不可以用两次，所以从map中取出来的元素index一定要与当前的index判断是否相等
     * (2) 注意如果数组中有重复的元素，为什么该算法依然可以正确的工作！！！
     *
     * @param nums   待处理的数组
     * @param target 求和目标元素
     * @return 和为目标元素target的两个index
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sum1 = nums[i];
            int sum2 = target - sum1;
            // 注意同一个元素不可以用两次，因此需要判定map.get(sum2) != i
            if (map.containsKey(sum2) && map.get(sum2) != i)
                return new int[]{i, map.get(sum2)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static void printArr(int[] nums) {
        System.out.print(nums[0] + " " + nums[1]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        int target = 6;
        printArr((new TwoSum1()).twoSum(nums, target));
    }
}
