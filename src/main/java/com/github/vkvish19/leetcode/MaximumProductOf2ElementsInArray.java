package com.github.vkvish19.leetcode;

public class MaximumProductOf2ElementsInArray
{
    public static void main(String[] args)
    {
        // Constraint: array size is at least 2
        System.out.println("Product : " + maximumProductOf2ElementsInArray(new int[] {3, 4, 5, 2}));
        System.out.println("Product : " + maximumProductOf2ElementsInArray(new int[] {1, 3}));
        System.out.println("Product : " + maximumProductOf2ElementsInArray(new int[] {10, 7, 2, 11, 6, 19, 20, 101, 0, 26}));
    }
    
    public static int maximumProductOf2ElementsInArray(int[] arr)
    {
        int h1;
        int h2;
        if(arr[1] >= arr[0])
        {
            h1 = arr[1];
            h2 = arr[0];
        }
        else
        {
            h1 = arr[0];
            h2 = arr[1];
        }
        int len = arr.length;
        for(int i=2; i<len; i++)
        {
            if(arr[i] >= h1)
            {
                h2 = h1;
                h1 = arr[i];
            }
            else if(arr[i] < h1 && arr[i] > h2)
            {
                h2 = arr[i];
            }
        }
        return (h1-1) * (h2-1);
    }
}
