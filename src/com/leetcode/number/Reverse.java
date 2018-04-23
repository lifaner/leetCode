package com.leetcode.number;

public class Reverse {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * Example :Input: 123  -> Output: 321
     * Input: -123 -> Output: -321
     * Input: 120  -> Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers
     * within the 32-bit signed integer range: [−2^31,  2^31 − 1].
     * For the purpose of this problem, assume that
     * your function returns 0 when the reversed integer overflows
     */
    public int reverse(int x) {
        int res = 0,tail;
        if(x == 0) return 0;
        while (x != 0) {
            int exp = res * 10 + (tail = x % 10);
            if (res != (exp - tail) / 10)
                return 0;
            res = exp;
            x = x / 10;
        }
        return res;
    }

    /**
     * 最优
     * @param x
     * @return
     */
    public int reverse2(int x) {
        long result = 0;
        long num = (long) x;
        while (num != 0){
            result *= 10;
            result += num % 10;
            num /= 10;
        }
        int test = (int) result;
        if (test == result) return test;
        return 0;
    }

    public static void main(String[] args) {
        int x = -2147483412;
        Reverse reverse = new Reverse();
        int res = reverse.reverse(x);
        System.out.println(res);
    }
}
