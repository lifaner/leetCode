package com.leetcode;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

public class Solution {

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger s1 = new BigInteger(listNodeToString(l1));
        BigInteger s2 = new BigInteger(listNodeToString(l2));
        String s3 = (s1.add(s2)) + "";
        ListNode ln = null;
        for (char c : s3.toCharArray()) {
            ListNode x = new ListNode(Integer.parseInt(c + ""));
            x.next = ln;
            ln = x;
        }
        return ln;
    }

    public String listNodeToString(ListNode ln) {
        String s = "";
        do {
            if (!s.equals("")) {
                s = ln.val + s;
            } else {
                s += ln.val;
            }
            ln = ln.next;
        } while (ln != null);
        return s;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;
        int head = 0;
        while (l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = head + x + y;
            head = sum/10;  //是否近1
            curr.next = new ListNode(sum%10);//将个位的和保留个位存在tmp
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(head > 0) curr.next = new ListNode(head);
        return tmp.next;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(9);
        l1.add(9);
        ListNode l2 = new ListNode(1);
        long start = new Date().getTime();
        ListNode res = s.addTwoNumbers2(l1, l2);
        System.out.println("用时：" + (new Date().getTime() - start));
        System.out.print("input: [" + l1 + "] ");
        System.out.println("[" + l2 + "]");
        System.out.println("output: " + res);

//        System.out.println(198%10);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void add(int x) {
        ListNode e;
        ListNode p = this;
        while (true) {
            if ((e = p.next) == null) {
                p.next = new ListNode(x);
                break;
            }
            p = e;
        }
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : (" -> " + next));
    }
}