package com.algorithms.leetcode.array;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int cursor = s.length() - 1;
        int length = 0;
        char[] arrayChar = s.toCharArray();
        for (; cursor >= 0; cursor--) {
            if (arrayChar[cursor] != ' ') {
                length++;
            } else {
                return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
    }
}
