package com.github.vkvish19.leetcode;

public class ApplyOperationsToAnArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 1, 1, 0};
        arr = applyOperations(arr);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static int[] applyOperations(int[] nums)
    {
        int k = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i++)
        {
            if(nums[i] == nums[i + 1])
            {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if(nums[i] != 0)
                nums[k++] = nums[i];
        }
        if(nums[n - 1] != 0)
            nums[k++] = nums[n - 1];
        for(int j = k; j < n; j++)
        {
            nums[j] = 0;
        }
        return nums;
    }
}
