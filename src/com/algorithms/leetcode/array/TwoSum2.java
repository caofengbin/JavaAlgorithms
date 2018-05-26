package com.algorithms.leetcode.array;

/**
 * leetcode 167，https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 题目描述：
 * 给定一个以升序排序的有序数组和一个target数字，从数组中找出两个元素使其和相加等于target，
 * 并输出两个元素的下标index
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;
        while (begin < end) {
            if (numbers[begin] + numbers[end] == target) {
                return new int[]{begin + 1, end + 1};
            } else if (numbers[begin] + numbers[end] < target) {
                begin++;
            } else {
                end--;
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    private static void printArr(int[] nums) {
        System.out.print(nums[0] + " " + nums[1]);
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        printArr((new TwoSum2()).twoSum(nums, target));
    }
}
