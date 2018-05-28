package com.algorithms.leetcode.array;

/**
 * leetcode 26  links:https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 题目描述：
 * 给定一个有序的数组，删除数组中的重复元素，并且返回删除成功之后数组的长度。
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // 容错处理
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int iteratorPointer = 1;                         // 迭代器指针
        // 当前正在遍历的非重复元素的指针，[0,currentRepeatPointer]前闭后闭区间，都是非重复的元素
        int currentRepeatPointer = 0;
        int currentRepeatData = nums[0];                         // 当前正在遍历的非重复元素值

        for (; iteratorPointer < nums.length; iteratorPointer++) {
            // 当前正在重复的元素
            if (currentRepeatData != nums[iteratorPointer]) {
                // 遇到的是非重复元素
                currentRepeatData = nums[iteratorPointer];
                currentRepeatPointer++;
                nums[currentRepeatPointer] = nums[iteratorPointer];
            }
        }

        return currentRepeatPointer + 1;
    }

    public static void main(String[] args) {
        int[] newNums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println((new RemoveDuplicatesFromSortedArray().removeDuplicates(newNums)));
        int[] newNums2 = {1, 1, 2};
        System.out.println((new RemoveDuplicatesFromSortedArray().removeDuplicates(newNums2)));
    }
}
