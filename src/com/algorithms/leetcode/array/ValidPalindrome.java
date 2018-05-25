package com.algorithms.leetcode.array;

/**
 * leetcode 125
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^(a-zA-Z0-9]", "");
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin <= end) {
            if (Math.abs(chars[begin] - chars[end]) == 0 ||
                    (Math.abs(chars[begin] - chars[end]) == 32 )) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}
