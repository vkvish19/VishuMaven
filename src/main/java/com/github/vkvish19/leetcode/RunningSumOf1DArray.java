package com.github.vkvish19.leetcode;

public class RunningSumOf1DArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 6, 10};
        int[] sumArray = getSumArray(arr);
        for(int i : sumArray)
        {
            System.out.print(i + " ");
        }
    }
    
    public static int[] getSumArray(int[] arr)
    {
        int[] sum = new int[arr.length];
        int currentSum = 0;
        for(int i=0; i<arr.length; i++)
        {
            sum[i] = currentSum + arr[i];
            currentSum = sum[i];
        }
        return sum;
    }
}
