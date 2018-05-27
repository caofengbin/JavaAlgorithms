package com.algorithms.leetcode.array;

/**
 * leetcode 27  links:https://leetcode.com/problems/remove-element/description/
 * 题目描述：
 * 给定一个数组以及一个指定的元素，删除数组中的指定元素，并返回删除完成之后的数组的长度
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // beginPointer代表的是[0,beginPointer)之间的元素全部是非val的
        int beginPointer = 0;
        int iteratorPointer = 0;
        for (; iteratorPointer < nums.length; iteratorPointer++) {
            if (nums[iteratorPointer] != val) {
                nums[beginPointer] = nums[iteratorPointer];
                beginPointer++;
            }
        }
        return beginPointer;
    }

    public static void main(String[] args) {
        int[] newNums = {3, 2, 2, 3};
        System.out.println(new RemoveElement().removeElement(newNums, 3));
        int[] newNums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement().removeElement(newNums2, 2));
    }
}
