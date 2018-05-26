package com.algorithms.leetcode.array;

/**
 * leetcode 125，links:https://leetcode.com/problems/valid-palindrome/description/
 * 题目描述：
 * 给定一个字符串，判断其是否为回文字符串，
 * 注意，只看其中的字母和数字，忽略字母的大小写
 */
public class ValidPalindrome {

    /**
     * 解法1：使用双指标进行收尾遍历，遇到非字母或数字的字符，修改指针下标，直至遍历完成
     *
     * @param s 原始字符串
     * @return 是否为符合要求的回文串
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin <= end) {
            if (isTargetChar(chars[begin]) && isTargetChar(chars[end])) {
                if (Math.abs(chars[begin] - chars[end]) == 0 ||
                        (Math.abs(chars[begin] - chars[end]) == 32)) {
                    begin++;
                    end--;
                } else {
                    return false;
                }
            } else if (!isTargetChar(chars[begin])) {
                begin++;
            } else if (!isTargetChar(chars[end])) {
                end--;
            }
        }
        return true;
    }

    private boolean isTargetChar(char targetChar) {
        return (targetChar >= 48 && targetChar <= 57) ||
                (targetChar >= 65 && targetChar <= 90) ||
                (targetChar >= 97 && targetChar <= 122);
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("? (So mad!)"));
        System.out.println(new ValidPalindrome().isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}
