package com.github.vkvish19.dynamic_programming;

public class DynamicProgrammingUtil
{
    public static void print2DIntegerArray(int[][] arr)
    {
        for(int i=0; i< arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
