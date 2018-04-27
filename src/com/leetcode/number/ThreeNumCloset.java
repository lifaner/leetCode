package com.leetcode.number;

import java.util.*;

public class ThreeNumCloset {
    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * Example:
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 0x7fffffff, min_sum = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i+1;j<nums.length-1;j++){
                int k = nums.length-1;
                while (j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    int instance;
                    //同符号相减 异符号相加
                    if(sum * target > 0){//同符号
                        instance = Math.abs(target-sum); //距离
                    }else{
                        instance = Math.abs(target+sum*-1); //距离
                    }
                    if(sum == target) return sum;
                    else if(min > instance){
                        min = instance;
                        min_sum = sum;
                    }
                    k--;
                }
            }

        }
        return min_sum ;
    }

    public static void main(String[] args) {
        ThreeNumCloset s = new ThreeNumCloset();
        int[] nums = new int[]{0,2,1,-3};
        int target = 1;
        int min = s.threeSumClosest(nums,target);
        System.out.println(min);
    }
}
