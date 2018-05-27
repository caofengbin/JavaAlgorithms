package com.algorithms.leetcode.array;

/**
 * leetcode 345  links:https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * 题目描述：
 * 将一个字符串中的元音字母(A,E,I,O,U)进行翻转并输出该字符串
 */
public class ReverseVowelsString {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int beginPosition = 0;
        int endPosition = s.length() - 1;
        while (beginPosition < endPosition) {
            if (isVowelsChar(charArray[beginPosition]) && isVowelsChar(charArray[endPosition])) {
                // 两个均为元音字母，进行交换
                char tempChar = charArray[beginPosition];
                charArray[beginPosition] = charArray[endPosition];
                charArray[endPosition] = tempChar;
                beginPosition++;
                endPosition--;
                continue;
            }
            // 未实现成功交换的，遇到非元音字母，修改相应的index指针位置
            if (!isVowelsChar(charArray[beginPosition])) {
                beginPosition++;
            }
            if (!isVowelsChar(charArray[endPosition])) {
                endPosition--;
            }
        }
        return new String(charArray);
    }

    /**
     * 判断给定的字符是否为元音字符
     *
     * @param targetChar 给定的字符
     * @return 是否为元音字符
     */
    private boolean isVowelsChar(char targetChar) {
        return targetChar == 'A' || targetChar == 'a' ||
                targetChar == 'E' || targetChar == 'e' ||
                targetChar == 'I' || targetChar == 'i' ||
                targetChar == 'O' || targetChar == 'o' ||
                targetChar == 'U' || targetChar == 'u';
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsString().reverseVowels("leetcode"));
    }
}
