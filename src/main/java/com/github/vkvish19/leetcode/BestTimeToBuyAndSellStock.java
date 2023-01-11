package com.github.vkvish19.leetcode;

public class BestTimeToBuyAndSellStock
{
    public static void main(String[] args)
    {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = getMaxProfitPossible(prices);
        System.out.println("maxProfit = " + maxProfit);
    }
    
    public static int getMaxProfitPossible(int[] prices)
    {
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        int buy = prices[0];
        int maxProfit = 0;
        for(int i=1; i< prices.length; i++)
        {
            buy = Math.min(buy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;
    }
}
