package com.algorithms.leetcode.array;

/**
 * leetcode 283   links:https://leetcode.com/problems/move-zeroes/description/
 * 题目描述：
 * 给定一个数组，将数组中的0元素放到数组的末尾，
 * 并且原数组中其他的非0元素顺序保持不变。
 */
public class MoveZero {

    /**
     * 解法1：采用暴力求解的方法，通过额外的一个数组，将原来数组中非0的元素放入，剩余的位置补上0即可
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     * @param nums 待处理的原始数组nums
     */
    public void moveZeroes(int[] nums) {
        int[] newNums = new int[nums.length];
        int newIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                newNums[newIndex] = nums[index];
                newIndex++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            nums[index] = newNums[index];
        }
        printlnString(nums);
    }

    private void printlnString(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            System.out.print(nums[index] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newNums = {0, 1, 0, 3, 12};
        new MoveZero().moveZeroes(newNums);
    }
}
