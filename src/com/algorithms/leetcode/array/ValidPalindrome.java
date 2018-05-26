package com.algorithms.leetcode.array;

/**
 * leetcode 125，links:https://leetcode.com/problems/valid-palindrome/description/
 * 给定一个字符串，判断其是否为回文字符串，注意，需要剔除其中非字母和数字的元素进行判断
 */
public class ValidPalindrome {

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

    public boolean isTargetChar(char targetChar) {
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
