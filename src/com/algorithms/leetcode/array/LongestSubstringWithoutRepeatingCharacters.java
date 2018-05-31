package com.algorithms.leetcode.array;

/**
 * leetcode 3  links:https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 寻找一个字符串中，最长的无重复子串
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 解题思路：采用滑动窗口的思想解决
     *
     * @param s 待处理的字符串
     * @return 最长的无重复子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 在区间[leftWindow,rightWindow]左闭右闭区间上，即为窗口的大小
        // 要点1：初始化的过程，因为要求的是在[leftWindow,rightWindow]左闭右闭区间上，所以初始化时需要保证
        // 窗口内没有元素，所以leftWindow为0，rightWindow为-1
        int leftWindow = 0;
        int rightWindow = -1;
        int result = -1;

        // 要点2：关于如何统计字符是否有重复的问题，在明确字符集大小的情况下，使用定长数组进行统计是最快速的
        int[] statistics = new int[256];
        char[] chars = s.toCharArray();

        // 要点3：关于滑动窗口的扫描边界问题，只要leftWindow < s.length()，则窗口可以继续向右移动
        while (leftWindow < s.length()) {
            if (rightWindow + 1 < s.length() && statistics[chars[rightWindow + 1]] == 0) {
                rightWindow++;
                statistics[chars[rightWindow]]++;
            } else {
                statistics[chars[leftWindow]]--;
                leftWindow++;
            }

            // 要点4：每一次移动完，就可以进行一次比较
            result = Math.max(result, rightWindow - leftWindow + 1);
        }

        return result == -1 ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("pwwkew"));
    }
}
