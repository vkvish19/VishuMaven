package com.github.vkvish19.leetcode;

import java.util.Arrays;

public class PlusOne
{
    public static void main(String[] args)
    {
        int[] num1 = {9, 9 , 9 , 9 , 9};
        int[] plusOne = getPlusOne(num1);
        Arrays.stream(plusOne).forEach(n -> System.out.print(n + " "));
    }
    
    private static int[] getPlusOne(int[] num)
    {
        for(int i = num.length - 1; i >= 0; i--)
        {
            if(num[i] < 9)
            {
                num[i] += 1;
                return num;
            }
            num[i] = 0;
        }
        int[] newNum = new int[num.length + 1];
        newNum[0] = 1;
        return newNum;
    }
}   
