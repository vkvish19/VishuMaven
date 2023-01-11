package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * This the base question of 0/1 knapsack, where we need to fill the knapsack with the given items - each with weights and values - and max weight capacity 
 * of the knapsack, such that the profit/value of the contents of the knapsack is maximum.
 * NOTE: we CANNOT repeat the item here.
 */
public class Knapsack01
{
    
    public static void main(String[] args)
    {
        int n = 4;
        int w = 7;
        int[] wt = {1, 2, 3, 4};
        int[] val = {1, 3, 5, 7};
        int[][] dp = new int[n + 1][w + 1];
        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < w + 1; j++)
            {
                dp[i][j] = -1;
            }
        }
        int maxProfitMemoization = knapsack01Memoization(wt, val, w, n, dp);
        int maxProfitTopDown = knapsack01TopDown(wt, val, w, n);
        System.out.println("maxProfit by knapsack01Memoization = " + maxProfitMemoization);
        System.out.println("maxProfit by knapsack01TopDown = " + maxProfitTopDown);
    }
    
    public static int knapsack01Memoization(int[] wt, int[] val, int w, int n, int[][] dp)
    {
        if(n == 0 || w == 0)
            return 0;
        
        if(dp[n][w] != -1)
            return dp[n][w];
        
        if(wt[n - 1] <= w)
        {
            dp[n][w] = Math.max(val[n - 1] + knapsack01Memoization(wt, val, w - wt[n - 1], n - 1, dp),
                    knapsack01Memoization(wt, val, w, n - 1, dp));
        }
        else
        {
            dp[n][w] = knapsack01Memoization(wt, val, w, n - 1, dp);
        }
        return dp[n][w];
    }
    
    public static int knapsack01TopDown(int[] wt, int[] val, int w, int n)
    {
        int[][] t = new int[n+1][w+1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<w+1; j++)
            {
                if(i==0 || j==0)
                    t[i][j] = 0;
            }
        }
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
                if(wt[i-1] <= j)
                {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
