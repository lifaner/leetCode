package com.leetcode.number;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    /**
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 思路
         *  排出几种不可能 都是正数 或 都是负数
         */
        List<List<Integer>> solutions = new LinkedList<>();
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> solution = new LinkedList<>();
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(nums[k]);
                    temp.add(solution);
                    j++;
                }else if(sum > 0){
                    k--;
                }else
                    j++;
            }
        }
        solutions.addAll(temp);
        return solutions;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> list = ts.threeSum(arr);
        System.out.println(list);
    }
}
