package com.algorithms.leetcode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 350  links:https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * 题目描述：
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 注意：这里对重复的元素不需要剔重！！！
 */
public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 第一遍遍历，将数组nums1中的元素放入到Hash表当中,numsHash1存在着对各个元素的出现频率统计
        HashMap<Integer, Integer> numsHash1 = new HashMap<>();
        for (int index = 0; index < nums1.length; index++) {
            int indexNum = nums1[index];
            if (numsHash1.containsKey(indexNum)) {
                numsHash1.put(indexNum, numsHash1.get(indexNum) + 1);
            } else {
                numsHash1.put(indexNum, 1);
            }
        }

        // 遍历数组nums2中的元素存在于numsHash1当中的次数
        List<Integer> resultNum = new ArrayList<>();
        for (int index = 0; index < nums2.length; index++) {
            int indexNum = nums2[index];
            if (numsHash1.containsKey(indexNum) && numsHash1.get(indexNum) > 0) {
                numsHash1.put(indexNum, numsHash1.get(indexNum) - 1);
                resultNum.add(indexNum);
            }
        }

        int[] resultArray = new int[resultNum.size()];
        for (int i = 0; i < resultNum.size(); i++) {
            resultArray[i] = resultNum.get(i);
        }
        return resultArray;
    }

    private static void printlnArray(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            System.out.print(nums[index] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 1};
        printlnArray(new IntersectionOfTwoArrays2().intersect(nums1, nums2));
    }
}
