package com.github.vkvish19.leetcode;

public class MaximumSubarray
{
    public static void main(String[] args)
    {
        int[] num1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("{-2,1,-3,4,-1,2,1,-5,4} - sumOfLargestSubarray(num1) = " + sumOfLargestSubArray(num1));
        int[] num2 = {5, 4, -1, 7, 8};
        System.out.println("{5,4,-1,7,8} - sumOfLargestSubarray(num2) = " + sumOfLargestSubArray(num2));
        int[] num3 = {-2, 1};
        System.out.println("{1} - sumOfLargestSubarray(num3) = " + sumOfLargestSubArray(num3));
    }
    
    private static int sumOfLargestSubArray(int[] nums)
    {
        int currMax = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
