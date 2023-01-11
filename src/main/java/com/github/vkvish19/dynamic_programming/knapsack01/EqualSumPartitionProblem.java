package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * Here we need to split the array into 2 subsets such that summation of each subset elements are same.
 * This can be deduced to 'Subset Sum Problem'.
 * We can 1st get total array sum, see if it is odd/even.
 * if ODD -> then equal partition not possible
 * if EVEN -> then try to get 1 subset whose sum will be totalArraySum/2 - then other subset will automatically will have same sum.
 */
public class EqualSumPartitionProblem
{
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 6, 4, 11, 5};
        boolean areEqualSumPartitionsPossible = equalSumPartitionPossible(arr);
        System.out.println("areEqualSumPartitionsPossible = " + areEqualSumPartitionsPossible);
    }
    
    public static boolean equalSumPartitionPossible(int[] arr)
    {
        int n = arr.length;
        int sum = 0;
        for(int j : arr)
        {
            sum += j;
        }
        if(sum%2 != 0)
            return false;
        
        return subsetSumPossible(arr, sum/2, n);
    }
    
    public static boolean subsetSumPossible(int[] arr, int sum, int n)
    {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
