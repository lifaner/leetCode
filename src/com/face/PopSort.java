package com.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopSort {

    public int[] sort(int[] nums,String sign){
        if(nums.length <= 0) return new int[0];
        for(int i=0;i<nums.length - 1;i++){
            for(int j=i+1;j<nums.length;j++){
                int tmp = 0;
                if(sign.equals(">")){
                    if(nums[i] < nums[j]){
                        tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }else{
                    if(nums[i] > nums[j]){
                        tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        PopSort sort = new PopSort();
        int[] nums = new  int[]{3,4,1,5,2,3,7};
//        Arrays.stream(sort.sort(nums,">")).forEach(System.out::print);
    }
}
