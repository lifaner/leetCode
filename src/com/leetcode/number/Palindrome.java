package com.leetcode.number;

public class Palindrome {
    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     * Example 1:
     * Input: 121
     * Output: true
     * Example 2:
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int tail = x % 10, head = x;
        while (head != 0) {
            if (head < 10) {
                break;
            } else {
                head /= 10;
            }
        }
        if (tail != head) return false;
        int t = x, r = x % 10;
        boolean same = false;
        //111,222,333,44,555
        while (t != 0) {
            if (r == t % 10) {
                same = true;
                t = t / 10;
                continue;
            } else {
                same = false;
                break;
            }
        }
        if (same) return true;
        //121,1001
        t = x;
        r = 0;
        int reverseNum = 0;
        while (t != 0) {
            r = r * 10 + t % 10;
            t = t / 10;
        }
        if (r == x) return true;
        return false;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        int x = 121;
        System.out.println(p.isPalindrome(x));
    }
}
