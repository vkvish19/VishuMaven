package com.github.vkvish19.leetcode;

public class ReverseInteger
{
    public static void main(String[] args)
    {
        ReverseInteger reverseInteger = new ReverseInteger();
        int value = reverseInteger.reverse(-123);
        System.out.println("value = " + value);
    }
    
    public int reverse(int x)
    {
        long r = 0;
        while(x != 0)
        {
            r = (r * 10) + (x % 10);
            x /= 10;
        }
        return (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) ? 0 : (int) r;
    }
}
