package com.github.vkvish19.dynamic_programming.knapsack01;

/**
 * Here we need to get count when we split array into 2 subsets and difference in their summations is equal to given difference.
 * So here we use formula:
 * sum(subset1) = (sum(array) + diff) / 2
 * if ODD -> then count = 0
 * if EVEN -> then it gets deduced to 'Count of Subset Sum with Given Sum Problem'
 */
public class CountNumberOfSubsetWithGivenDifference
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int count = countOfSubsetSumWithGivenDifference(arr, diff);
        System.out.println("count = " + count);
    }
    
    public static int countOfSubsetSumWithGivenDifference(int[] arr, int diff)
    {
        int n = arr.length;
        int sum = 0;
        for(int i : arr)
        {
            sum += i;
        }
        
        if((sum + diff)%2 != 0)
            return 0;
        
        int sum1 = (sum + diff)/2;
        int t[][] = new int[n + 1][sum1 + 1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum1+1; j++)
            {
                if(i == 0)
                    t[i][j] = 0;
                if(j == 0)
                    t[i][j] = 1;
            }
        }
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum1+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum1];
    }
}
