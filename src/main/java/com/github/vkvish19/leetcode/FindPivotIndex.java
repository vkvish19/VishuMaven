package com.github.vkvish19.leetcode;

public class FindPivotIndex
{
    public static void main(String[] args)
    {
        int[] arr = {1, 7, 3, 6, 5, 6};
//        int[] arr = {-1, -1, -1, -1, 0, 1};
        int index = getPivotIndex(arr);
        System.out.println("index = " + index);
    }
    
    public static int getPivotIndex(int[] arr)
    {
        int total = 0;
        int left = 0;
        for(int num : arr)
        {
            total += num;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(left*2 == total-arr[i])
            {
                return i;
            }
            left += arr[i];
        }
        return -1;
    }
}
