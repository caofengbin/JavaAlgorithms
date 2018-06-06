package com.algorithms.leetcode.array;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] totalNum = new int[256];
        char[] arrayMagizine = magazine.toCharArray();
        char[] arrayRansom = ransomNote.toCharArray();
        for (int i = 0; i < arrayMagizine.length; i++) {
            totalNum[arrayMagizine[i]]++;
        }
        for (int i = 0; i < arrayRansom.length; i++) {
            totalNum[arrayRansom[i]]--;
            if (totalNum[arrayRansom[i]] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa","ab"));
        System.out.println(new RansomNote().canConstruct("aa","aab"));
    }

}
