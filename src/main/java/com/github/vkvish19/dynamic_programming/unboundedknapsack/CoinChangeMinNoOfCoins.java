package com.github.vkvish19.dynamic_programming.unboundedknapsack;

public class CoinChangeMinNoOfCoins
{
    public static void main(String[] args)
    {
        int[] coin = {1, 2, 3};
        int sum = 5;
        int minNoOfCoins = getMinNoOfCoinsToMakeGivenSum(coin, sum);
        System.out.println("minNoOfCoins = " + minNoOfCoins);
    }
    
    public static int getMinNoOfCoinsToMakeGivenSum(int[] coin, int sum)
    {
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];
        initializeDP(dp, coin, n, sum);
        for(int i=2; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(coin[i-1] <= j)
                {
                    dp[i][j] = Math.min(1+dp[i][j-coin[i-1]], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n][sum];
    }
    
    private static void initializeDP(int[][] dp, int[] coin, int n, int sum)
    {
        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < sum + 1; j++)
            {
                if(j == 0)
                {
                    dp[i][j] = 0;
                }
                if(i == 0)
                {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }
                if(i == 1 && j != 0)
                {
                    initializeDPFirstRow(dp, coin, i, j);
                }
            }
        }
    }
    
    private static void initializeDPFirstRow(int[][] dp, int[] coin, int i, int j)
    {
        if(j%coin[i-1] == 0)
        {
            dp[i][j] = j/coin[i-1];
        }
        else
        {
            dp[i][j] = Integer.MAX_VALUE - 1;
        }
    }
}
