package com.algorithms.leetcode.array;

/**
 * leetcode 75  links:https://leetcode.com/problems/sort-colors/description/
 * 给定一个数组，只包含0,1,2三个元素，对这个数组进行排序
 */
public class SortColors {

    /**
     * 解法1：计数排序法。
     * 对于元素有限的数组，可以采用计数排序法进行统计，然后重新填充数组即可。
     *
     * @param nums 待排序的数组
     */
    public int[] sortColors(int[] nums) {
        int[] totalNum = new int[3];
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    totalNum[0]++;
                    break;
                case 1:
                    totalNum[1]++;
                    break;
                case 2:
                    totalNum[2]++;
                    break;
                default:
                    throw new RuntimeException("UnExcepted number!!!");
            }
        }

        // 重新填充数组中的元素
        int index = 0;
        for (int i = 0; i < totalNum[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < totalNum[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < totalNum[2]; i++) {
            nums[index++] = 2;
        }

        return nums;
    }

    /**
     * 解法2：采用三路排序的方法解决，比较经典的方式
     *
     * @param nums 待排序的数组
     * @return 排序完成的数组
     */
    public int[] sortColors2(int[] nums) {
        int zeroPointer = -1;                   // [0,zeroPointer]之间的元素为0
        int twoPointer = nums.length;           // [twoPointer, len(nums) - 1]之间的元素为2
        for (int i = 0; i < twoPointer; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                twoPointer--;
                swap(nums, twoPointer, i);
            } else if (nums[i] == 0) {
                zeroPointer++;
                swap(nums, zeroPointer, i);
                i++;
            } else {
                throw new RuntimeException("UnExcepted number!!!");
            }
        }
        return nums;
    }

    private void swap(int[] num, int index1, int index2) {
        int temp = num[index1];
        num[index1] = num[index2];
        num[index2] = temp;
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 6};
        printArr(new SortColors().sortColors2(nums));
    }
}
