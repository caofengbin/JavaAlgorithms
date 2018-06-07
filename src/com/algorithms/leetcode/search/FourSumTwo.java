package com.algorithms.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 454 links:https://leetcode.com/problems/4sum-ii/description/
 * 题目大意：
 * 给定4个整型数组A,B,C,D,寻找有多少个i,j,k,l个组合，
 * 使得A[i]+B[j]+C[k]+D[l]=0
 * 解题思路分析：
 * 使用典型的查找表，将后面两个数组中的所有和的可能性放到一个集合当中。
 */
public class FourSumTwo {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (valueMap.containsKey(sum)) {
                    valueMap.put(sum, valueMap.get(sum) + 1);
                } else {
                    valueMap.put(sum, 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = -A[i] - B[j];
                if (valueMap.containsKey(sum)) {
                    result += valueMap.get(sum);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0};
        int[] nums2 = {1};
    }

}
