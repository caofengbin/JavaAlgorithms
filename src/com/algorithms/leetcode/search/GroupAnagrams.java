package com.algorithms.leetcode.search;

import java.util.*;

/**
 * leetcode 49 links:https://leetcode.com/problems/group-anagrams/description/
 * 题目描述：
 * Given an array of strings, group anagrams together.
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static boolean isAnagrams(String aStr, String bStr) {
        if (aStr == null || bStr == null) {
            return false;
        }
        if (aStr.length() != bStr.length()) {
            return false;
        }
        int[] charAStr = new int[256];
        char[] charArrayStr = aStr.toCharArray();
        for (int i = 0; i < charArrayStr.length; i++) {
            charAStr[charArrayStr[i]]++;
        }
        char[] charArrayStrB = bStr.toCharArray();
        for (int i = 0; i < charArrayStrB.length; i++) {
            charAStr[charArrayStrB[i]]--;
            if (charAStr[charArrayStrB[i]] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().isAnagrams("abc", "bac"));
    }

}
