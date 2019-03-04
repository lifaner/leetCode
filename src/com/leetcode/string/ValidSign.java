package com.leetcode.string;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * Date: 2019/3/4.
 * Time: 10:50.
 */
public class ValidSign {

    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() % 2 != 0) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char item = s.charAt(i);
            if(map.containsKey(item)){
                char top = stack.isEmpty() ? '#' : stack.pop();
                if(top != map.get(item)){
                    return false;
                }
            }else stack.push(item);
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidSign vs = new ValidSign();
        String s = "{{(([[]]{}{}))}}}{{}{}()()([])";
        System.out.println(vs.isValid(s));
    }
}
