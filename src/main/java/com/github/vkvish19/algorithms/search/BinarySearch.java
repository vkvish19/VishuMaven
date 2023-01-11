package com.github.vkvish19.algorithms.search;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 4, 4, 6, 8, 10, 11, 23, 45};    // array needs to be sorted for binary search
        int k = 11;
        int index = getIndexOfNumberUsingRecursion(nums, k, 0, nums.length - 1);
        System.out.println("index = " + index);
    
        System.out.println("getV(nums, k, 0, nums.length - 1) = " + getV(nums, k, 0, nums.length - 1));
    }
    
    protected static int getIndexOfNumberUsingRecursion(int[] nums, int k, int beg, int end)
    {
        int index = -1;
        if(end >= beg)
        {
            int mid = (beg + end)/2;
            if(nums[mid] == k)
            {
                index =  mid;
            }
            else if(nums[mid] < k)
            {
                beg = mid + 1;
                index =  getIndexOfNumberUsingRecursion(nums, k, beg, end);
            }
            else if(nums[k] > k)
            {
                end = mid - 1;
                index =  getIndexOfNumberUsingRecursion(nums, k, beg, end);
            }
        }
        return index;
    }
    
    protected static int getV(int[] arr, int k, int beg, int end)
    {
        int index = -1;
        if(end >= beg)
        {
            int mid = (beg+end)/2;
            if(arr[mid] == k)
            {
                index =  mid;
            }
            else if(arr[mid] > k)
            {
                end = mid - 1;
                index =  getV(arr, k, beg, end);
            }
            else
            {
                beg = mid + 1;
                index =  getV(arr, k, beg, end);
            }
        }
        return index;
    }
}
