package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * Here we need the count of subsets whose sum is equal to the given sum value.
 * This can be deduced to 'Subset Sum Problem' but instead of saying True/False or Possible/Not Possible, here we need to give the count.
 * To do that, we simply need to store count value in t[][] instead of true/false & instead of using '||' we can use '+' to get count.
 */
public class CountOfSubsetSumWithGivenSum
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int count = getCountOfSubsetSumWithGivenSum(arr, sum);
        System.out.println("count = " + count);
    }
    
    public static int getCountOfSubsetSumWithGivenSum(int[] arr, int sum)
    {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        
        // initialization
        for(int i=0; i< n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;
            }
        }
        
        // code
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
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
