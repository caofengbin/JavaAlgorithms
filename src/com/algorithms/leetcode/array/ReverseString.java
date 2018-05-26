package com.algorithms.leetcode.array;

/**
 * leetcode 344  links:https://leetcode.com/problems/reverse-string/description/
 * 题目描述：
 * 给定一个字符串，将其翻转输出
 */
public class ReverseString {

    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            char temp = charArray[end];
            charArray[end] = charArray[begin];
            charArray[begin] = temp;
            begin++;
            end--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("abc2"));
        System.out.println(new ReverseString().reverseString("12345"));
        System.out.println(new ReverseString().reverseString("Acdf789"));
        System.out.println(new ReverseString().reverseString(""));
    }
}
