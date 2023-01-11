package com.github.vkvish19.dynamic_programming.knapsack01;

import java.util.ArrayList;
import java.util.List;

/**
 * Here we need to split array into 2 subsets such that the difference in their summations is minimum.
 * We can get the range for this (0 to totalArraySum). Now deduce this to 'Subset Sum Problem' and create the boolean t[][] matrix.
 * Now in this, we will only see the last row (i == n), create a vector/list where value is TRUE and store all those items (value of j) in vector (but we 
 * will store only till range+1/2).
 * Now we will iterate over this list/vector (who contains value of 'j' which is summation values) and figure out the minimum using the formula:
 * range - 2*list.get(i)
 */
public class MinimumSubsetSumDifference
{
    public static void main(String[] args)
    {
        System.out.println("minimumSubsetSumDifference of {1, 2, 7} = " + getMinimumSubsetSumDifference(new int[] {1, 2, 7}));
        System.out.println("minimumSubsetSumDifference of {1, 6, 11, 5} = " + getMinimumSubsetSumDifference(new int[] {1, 6, 11, 5}));
        System.out.println("minimumSubsetSumDifference of {1, 1} = " + getMinimumSubsetSumDifference(new int[] {1, 1}));
    }
    
    public static int getMinimumSubsetSumDifference(int[] arr)
    {
        int n = arr.length;
        int range = 0;
        for(int value : arr)
        {
            range += value;
        }
        boolean[][] t = new boolean[n + 1][range + 1];
        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < range + 1; j++)
            {
                if(i == 0)
                    t[i][j] = false;
                if(j == 0)
                    t[i][j] = true;
            }
        }
        
        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < range + 1; j++)
            {
                if(arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
            
        }
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j <= (range+1)/2; j++)
        {
            if(t[n][j])
                list.add(j);
        }
        
        int min = Integer.MAX_VALUE;
        for(int entry : list)
        {
            min = Math.min(min, range - 2*entry);
        }
        
        return Math.abs(min);
    }
}
