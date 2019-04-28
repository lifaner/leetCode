package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by lifan.
 * Date: 2019/3/4.
 * Time: 16:27.
 */
public class LetterCasePermutation {


    /**
     * 待优化
     *
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     *
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     *
     * 输入: S = "12345"
     * 输出: ["12345"]
     * 注意：
     *
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     * @param s
     */
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("");
        if(s == null || s.length() <=0 ) return objects;
        char[] chars = s.toCharArray();

        return handleString(chars,0,objects);
    }

    private List<String> handleString(char[] cs, int index,List<String> list){
        char c = cs[index];
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){//字母
            char lc = Character.toLowerCase(c);
            char uc = Character.toUpperCase(c);
            List<String> low_list = list.stream().map(x-> x+=lc).collect(Collectors.toList());
            List<String> upper_list = list.stream().map(x-> x+=uc).collect(Collectors.toList());
            list = new ArrayList<>();
            list.addAll(low_list);
            list.addAll(upper_list);

        }else{//数字
            list = list.stream().map(x-> x+c).collect(Collectors.toList());
        }
        if(index < cs.length - 1){
            return handleString(cs,index + 1,list);
        }
        return list;
    }


    public List<String> letterCasePermutation1(String S) {
        List<String> list =new ArrayList<>();
        if(S == null) return list;
        dfs(S.toCharArray(), 0, list);
        return list;
    }

    void dfs(char []chars, int index, List<String> list)
    {
        if(index == chars.length)
        {
            list.add(new String(chars));
            return;
        }
        char c = chars[index];
        dfs(chars, index+1, list);
        if(chars[index] >= 'a')
        {
            chars[index] = (char)(chars[index] - 32);
            dfs(chars, index+1, list);
        }
        else if(chars[index] >= 'A')
        {
            chars[index] =  (char)(chars[index] + 32);
            dfs(chars, index+1, list);
        }

        chars[index] = c;

    }


    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 2-abc 3-def 4-ghi 5-jkl 6-mno 7-pqrs 8-tuv 9-wxyz
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     * @param digits
     */
    public static final String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return list;
        dfs2(digits, "");
        return list;
    }

    private void dfs2(String digits,String result){
        if(digits.length() == 0){
            list.add(result);
            return;
        }
        String codeStr = strings[Integer.parseInt(digits.substring(0,1))];
        for(int i=0;i<codeStr.length();i++){
            String c = codeStr.substring(i,i+1);
            dfs2(digits.substring(1),result + c);
        }
    }


    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if(n > 0){
            dsf3(n-1,n,"(");
        }
        return list;
    }

    private void dsf3(int left,int right, String result){
        if(right == 0 && left == 0) {
            list.add(result);
            return;
        }

        if(left > 0){
            dsf3(left-1 ,right, result+"(");
        }

        if(right > left){
            dsf3(left ,right-1, result+")");
        }
    }


    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * @param args
     */


    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        List<String> list = l.generateParenthesis(2);
        list.forEach(System.out::println);
//        System.out.println((int) '1');

    }
}
