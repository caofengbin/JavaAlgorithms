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

    /**
     * 方法2：采用双指针法
     * 一个指针从数组的头部开始进行遍历，
     * 一个指针代表着数组中的非0元素区间，[0,k),
     * K以后的元素全部用0元素进行再次填充即可。
     *
     * @param nums 待处理的原始数组nums
     */
    public void moveZeroes2(int[] nums) {
        int iteratorPointer;                        // 数组迭代器指针
        int nonZeroPointer = 0;                     // 非0元素赋值指针
        for (iteratorPointer = 0; iteratorPointer < nums.length; iteratorPointer++) {
            if (nums[iteratorPointer] != 0) {
                nums[nonZeroPointer] = nums[iteratorPointer];
                nonZeroPointer++;
            }
        }

        // 一次遍历完成，数组中的所有非0元素已经移动到 [0,nonZeroPointer) 区间当中，接下来只需要将
        // [nonZeroPointer,nums.lenth)区间中的元素全部填充为0即可
        for (; nonZeroPointer < nums.length; nonZeroPointer++) {
            nums[nonZeroPointer] = 0;
        }

        printlnString(nums);
    }

    /**
     * 方法3：方法2的一个改进版本，方法2中一个不足之处在于，
     * 数组迭代器遍历完成之后，
     * 还需要将非0元素的迭代器指针继续遍历的数组尾部进行赋0的操作。
     * 主要对这里的操作进行一个优化
     *
     * @param nums 待处理的原始数组nums
     */
    public void moveZeroes3(int[] nums) {
        int iteratorPointer;
        int nonZeroPointer = 0;
        for (iteratorPointer = 0; iteratorPointer < nums.length; iteratorPointer++) {
            if (nums[iteratorPointer] != 0) {
                // 找到了一个非0元素，进行交换，保证[0,nonZeroPointer)区间中的元素全部非0
                if (iteratorPointer != nonZeroPointer) {
                    swap(nums, iteratorPointer, nonZeroPointer);
                    nonZeroPointer++;
                } else {
                    nonZeroPointer++;
                }
            }
        }

        printlnString(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void printlnString(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            System.out.print(nums[index] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newNums = {2, 1};
        new MoveZero().moveZeroes3(newNums);
    }
}
