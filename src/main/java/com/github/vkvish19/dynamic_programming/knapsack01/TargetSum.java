package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * Here we need to assign +/- to each element in array and then add them all to get the desired/requested Sum.
 * This can be deduced into 'Count of Subset sum with given difference'
 */
public class TargetSum
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 2, 3};
        int sum = 1;
        int count = getTargetSumPossibleCount(arr, sum);
        System.out.println("count = " + count);
    }
    
    public static int getTargetSumPossibleCount(int[] arr, int sum)
    {
        int n = arr.length;
        int total = 0;
        for(int i : arr)
            sum += i;
        
        if((sum + total)%2 != 0)
            return 0;
    
        int totalOfSubset1 = (sum + total) /2;
        int[][] t = new int[n+1][totalOfSubset1+1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<totalOfSubset1+1; j++)
            {
                if(i ==0)
                    t[i][j] = 0;
                
                if(j==0)
                    t[i][j] = 1;
            }
        }
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<totalOfSubset1+1; j++)
            {
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        
        return t[n][totalOfSubset1];
    }
}
