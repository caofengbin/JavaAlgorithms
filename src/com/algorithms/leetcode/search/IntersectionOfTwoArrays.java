package com.algorithms.leetcode.search;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(num1Set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] resultInteger = new int[resultSet.size()];
        int index = 0;
        for (int tempData : resultSet) {
            resultInteger[index++] = tempData;
        }
        return resultInteger;
    }

    private static void printlnArray(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            System.out.print(nums[index] + "    ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        printlnArray(new IntersectionOfTwoArrays().intersection(nums1, nums2));
    }
}
