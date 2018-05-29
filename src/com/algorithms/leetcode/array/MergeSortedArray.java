package com.algorithms.leetcode.array;

/**
 * leetcode 88  links:https://leetcode.com/problems/merge-sorted-array/description/
 * 给定两个有序的数组，将他们进行合并
 */
public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int totalPointer = m + n - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[totalPointer] = nums1[pointer1];
                pointer1--;
                totalPointer--;
            } else {
                nums1[totalPointer] = nums2[pointer2];
                pointer2--;
                totalPointer--;
            }
        }

        while (pointer1 >= 0) {
            nums1[totalPointer--] = nums1[pointer1--];
        }
        while (pointer2 >= 0) {
            nums1[totalPointer--] = nums2[pointer2--];
        }
        return nums1;

    }

    private static void printlnArray(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            System.out.print(nums[index] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        printlnArray(new MergeSortedArray().merge(nums1, 3, nums2, nums2.length));
    }

}