package com.algorithms.leetcode.array;

/**
 * leetcode 80  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * 题目描述：
 * 给定一个有序的数组，删除数组中的重复元素(最多保留两个)，并且返回删除成功之后数组的长度。
 */
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        // 容错处理
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int iteratorPointer = 1;                                // 迭代器指针
        // 当前正在遍历的非重复元素的指针，[0,currentRepeatPointer]前闭后闭区间，都是至多重复2次的元素
        int currentRepeatPointer = 0;
        int currentRepeatData = nums[0];                         // 当前正在遍历的非重复元素值
        int currentRepeatTime = 1;                               // 当前正在遍历的元素的重复次数(唯一一个新增加的变量)

        for (; iteratorPointer < nums.length; iteratorPointer++) {
            // 与当前正在重复遍历的元素不相同，
            if (currentRepeatData != nums[iteratorPointer]) {
                // 遇到的是非重复元素
                currentRepeatData = nums[iteratorPointer];
                currentRepeatPointer++;
                nums[currentRepeatPointer] = nums[iteratorPointer];
                currentRepeatTime = 1;
            } else if (currentRepeatData == nums[iteratorPointer]) {
                // 与当前正在重复遍历的元素相同
                if (currentRepeatTime < 2) {
                    currentRepeatData = nums[iteratorPointer];
                    currentRepeatPointer++;
                    nums[currentRepeatPointer] = nums[iteratorPointer];
                    currentRepeatTime++;
                }
            }
        }

        return currentRepeatPointer + 1;
    }

    public static void main(String[] args) {
        int[] newNums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println((new RemoveDuplicatesFromSortedArray2().removeDuplicates(newNums)));
        int[] newNums2 = {1, 1, 1, 2, 2, 3};
        System.out.println((new RemoveDuplicatesFromSortedArray2().removeDuplicates(newNums2)));
    }
}
