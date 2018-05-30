package com.algorithms.leetcode.array;

/**
 * leetcode 9   links:https://leetcode.com/problems/palindrome-number/description/
 * <p>
 * description:
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int origin = x;
        if (x < 0) {
            return false;
        } else {
            int reverseNum = 0;
            while (x > 0) {
                reverseNum = reverseNum * 10 + x % 10;
                x = x / 10;
            }
            return reverseNum == origin;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
        System.out.println(new PalindromeNumber().isPalindrome(-1));
        System.out.println(new PalindromeNumber().isPalindrome(10));
    }
}
