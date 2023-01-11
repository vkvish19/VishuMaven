package com.github.vkvish19.dynamic_programming.unboundedknapsack;

/**
 * This the base question of 0/1 knapsack, where we need to fill the knapsack with the given items - each with weights and values - and max weight capacity 
 * of the knapsack, such that the profit/value of the contents of the knapsack is maximum.
 * NOTE: we CAN repeat the items here.
 */
public class UnboundedKnapsack
{
    public static void main(String[] args)
    {
        int n = 4;
        int w = 22;
        int[] wt = {1, 2, 3, 7};
        int[] val = {10, 5, 1, 4};
        int maxProfitUnboundedKnapsack = getMaxProfitFromUnboundedKnapsack(wt, val, w, n);
        System.out.println("maxProfitUnboundedKnapsack = " + maxProfitUnboundedKnapsack);
    }
    
    public static int getMaxProfitFromUnboundedKnapsack(int[] wt, int[] val, int w, int n)
    {
        int[][] dp = new int[n+1][w+1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<w+1; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
                if(wt[i-1] <= j)
                {
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
