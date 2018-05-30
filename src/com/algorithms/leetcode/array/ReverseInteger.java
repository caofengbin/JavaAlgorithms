package com.algorithms.leetcode.array;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * leetcode 7   links:https://leetcode.com/problems/reverse-integer/description/
 * description:Given a 32-bit signed integer, reverse digits of an integer.
 * Input: 123
 * Output: 321
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    public int reverse(int x) {
        //反转后为answer
        int answer = 0;
        int n;
        while (x != 0) {
            //从后至前获取每一位数字
            n = x % 10;
            //溢出返回0
            if (answer > Integer.MAX_VALUE / 10 || answer < Integer.MIN_VALUE / 10) {
                return 0;
            }

            answer = answer * 10 + n;
            x = x / 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(-2147483412));
        System.out.println(new ReverseInteger().reverse(-123));
    }
}
