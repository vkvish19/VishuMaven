package com.github.vkvish19.dynamic_programming.unboundedknapsack;

/**
 * We are given a rod of length 'n', and price[] for each smaller size (1->N) usually.
 * Here we need to cut the rod into pieces such that the profit earned is maximum.
 */
public class RodCutting
{
    public static void main(String[] args)
    {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 2, 3, 5, 10, 6, 1, 8};
        int n = 8;
        int maxProfitFromRodCutting = getMaxProfitFromRodCutting(price, length, n);
        System.out.println("maxProfitFromRodCutting = " + maxProfitFromRodCutting);
    }
    
    public static int getMaxProfitFromRodCutting(int[] price, int[] length, int n)
    {
        int[][] dp = new int[n + 1][length.length + 1];
        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < length.length + 1; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j < length.length + 1; j++)
            {
                if(length[i - 1] <= j)
                {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][length.length];
    }
}
