package com.github.vkvish19.leetcode;

import java.util.Arrays;

public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] output = twoSum(nums, target);
        System.out.println("[" + output[0] + ", " + output[1] +"]");
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = {-1,-1};
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i; j<nums.length; j++)
            {
                if(i != j && (nums[i]+nums[j] == target))
                {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return new int[0];
    }
}
