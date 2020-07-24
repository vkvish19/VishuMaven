package com.github.vkvish19.corejava;

public class TokenBucketExample
{
    private final long capacity;
    private final double refillTokensPerOneMillis;
    
    private long lastRefillTimestamp;
    private double availableTokens;
    
    public TokenBucketExample(long capacity, long refillTokens, long refillPeriodMillis)
    {
        this.capacity = capacity;
        this.refillTokensPerOneMillis = (double) refillTokens / (double) refillPeriodMillis;
        availableTokens = capacity;
        lastRefillTimestamp = System.currentTimeMillis();
    }
    
    synchronized public boolean tryConsume(int numberOfTokens)
    {
        refill();
        if(numberOfTokens < availableTokens)
        {
            return false;
        }
        else
        {
            availableTokens -= numberOfTokens;
            return true;
        }
    }
    
    private void refill()
    {
        try{ Thread.sleep(10); } catch(Exception e) { System.out.println("error to sleep"); }
        long currentTimeInMillis = System.currentTimeMillis();
        if(currentTimeInMillis > lastRefillTimestamp)
        {
            long millisSinceLastRefill = currentTimeInMillis - lastRefillTimestamp;
            double refillQuantity = millisSinceLastRefill * refillTokensPerOneMillis;
            availableTokens = Math.min(capacity, availableTokens + refillQuantity);
            System.out.println("refill() called after : " + millisSinceLastRefill + "ms ## availableTokens = " + availableTokens);
            lastRefillTimestamp = currentTimeInMillis;
        }
    }
    
    private static final class SelfTest
    {
        public static void main(String[] args)
        {
            TokenBucketExample tokenBucket = new TokenBucketExample(100, 100, 1000);
            long startTime = System.currentTimeMillis();
            long consumed = 0;
            while(System.currentTimeMillis() - startTime < 10000)
            {
                if(tokenBucket.tryConsume(110))
                    consumed++;
            }
            System.out.println("consumed = " + consumed);
        }
    }
}
