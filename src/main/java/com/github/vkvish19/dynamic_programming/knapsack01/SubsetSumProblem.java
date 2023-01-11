package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * Here we need to see if we can have subset from the given array, such that the sum of that subset is equal to the given sum.
 * This can be deduced from the knapsack solution.
 */
public class SubsetSumProblem
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        boolean isSubsetSumPossible = subsetSumPossible(arr, sum, arr.length);
        System.out.println("isSubsetSumPossible = " + isSubsetSumPossible);
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
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
