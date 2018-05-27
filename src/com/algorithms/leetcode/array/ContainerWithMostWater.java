package com.algorithms.leetcode.array;

/**
 * leetcode 11  links:https://leetcode.com/problems/container-with-most-water/description/
 * 题目描述：
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of
 * line i is at (i, ai) and (i, 0).
 * <p>
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * 找出可以容纳最多水的两个柱子。
 */
public class ContainerWithMostWater {

    /**
     * 思路分析：
     * 使用贪心算法
     * 1.首先假设我们找到能取最大容积的纵线为 i, j (假定i < j)，
     * 那么得到的最大容积 C = min( ai , aj ) * ( j- i) ；
     * <p>
     * 2.下面我们看这么一条性质：
     * (1) 在 j 的右端没有一条线会比它高！假设存在 k |( j < k && ak > aj) ，
     * 那么 由 ak > aj，所以 min(ai, aj, ak) =min(ai, aj) ，
     * 所以由i, k构成的容器的容积C’ = min(ai, aj) * (k - i) > C，与C是最值矛盾，
     * 所以得证j的后边不会有比它还高的线；
     * (2) 同理，在i的左边也不会有比它高的线；
     * 可以利用如下的思路进行解决:
     * 如果我们目前得到的候选:设为 x, y两条线（x< y)，
     * 那么能够得到比它更大容积的新的两条边必然在[x, y]区间内并且 ax’ >= ax , ay’ >= ay;
     * <p>
     * 3.所以我们从两头向中间靠拢，同时更新候选值；在收缩区间的时候优先从x, y中较小的边开始收缩；
     *
     * @param height 待处理的数组结构
     * @return 最大的面积
     */
    public int maxArea(int[] height) {
        int result = -1;

        // 参数校验
        if ((height == null) || (height.length == 0)) {
            return result;
        }

        // 定义左右指针
        int left = 0;
        int right = height.length - 1;

        // 分别寻找的左边最高的柱子，以及右边最高的柱子
        int leftMax = height[0];
        int rightMax = height[right];

        int area;
        while (left < right) {
            //  result = Math.max(result, ((right-left)*(Math.min(leftMax, rightMax))));
            if (leftMax < rightMax) {
                // 左边的柱子低于右边，寻找左边最高的柱子
                area = (right - left) * leftMax;
                left++;
                // 寻找左边最高的柱子
                if (leftMax < height[left]) {
                    leftMax = height[left];
                }
            } else {
                // 左边的柱子高于右边，寻找右边最高的柱子
                area = (right - left) * rightMax;
                right--;
                // 寻找右边最高的柱子
                if (rightMax < height[right]) {
                    rightMax = height[right];
                }
            }

            // 每一轮循环完成之后，判断最大面积是否发生更新
            if (area > result) {
                result = area;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] newNums = {1, 1};
        System.out.println(new ContainerWithMostWater().maxArea(newNums));
    }

}
