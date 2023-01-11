package com.github.vkvish19.algorithms.search;

public class LinearSearch
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 6, 4, 8, 11, 4, 23, 45, 10};
        int k = 8;
        int index = getIndexOfNumberUsingLinearSearch(nums, k);
        System.out.println("index = " + index);
    }
    
    protected static int getIndexOfNumberUsingLinearSearch(int[] nums, int k)
    {
        int index = -1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == k)
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
