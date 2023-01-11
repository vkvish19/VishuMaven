package com.github.vkvish19.leetcode;

import java.util.Arrays;

public class MaximumGap
{
    public static void main(String[] args)
    {
        System.out.println("Maximum gap : " + getMaximumGap(new int[] {3, 6, 9, 1}));
        System.out.println("Maximum gap : " + getMaximumGap(new int[] {3, 6, 9, 1, 7, 11, 100}));
        System.out.println("Maximum gap : " + getMaximumGap(new int[] {3}));
    }
    
    public static int getMaximumGap(int[] nums)
    {
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 2)
            return 0;
        int diff = Integer.MIN_VALUE;
        for(int i=1; i<len; i++)
        {
            if(nums[i] - nums[i-1] > diff)
                diff = nums[i] - nums[i-1];
        }
        return diff;
    }
}
