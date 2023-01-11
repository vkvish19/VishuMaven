package com.github.vkvish19.leetcode;

public class RemoveElement
{
    public static void main(String[] args)
    {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int val = 1;
        
        int k = removeElement(nums, val);
        System.out.println("k = " + k);
        for(int i = 0; i < k; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }
    
    public static int removeElement(int[] arr, int val)
    {
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;
        
        int idx = 0;
        int count = 0;
        int p1 = 0;
        
        while(p1 < arr.length)
        {
            if(arr[p1] == val)
            {
                count++;
            }
            else
            {
                arr[idx++] = arr[p1];
            }
            p1++;
        }
        
        return arr.length - count;
    }
}
