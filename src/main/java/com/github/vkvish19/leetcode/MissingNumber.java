package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String[] input = br.readLine().split(" ");
            int[] nums = new int[input.length];
            for(int i=0; i< input.length; i++)
            {
                nums[i] = Integer.parseInt(input[i]);
            }
            System.out.println(getMissingNumber(nums));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int getMissingNumber(int[] nums)
    {
        int diff = getSum(nums.length);
        for(int num : nums)
        {
            diff -= num;
        }
        return diff;
    }
    
    public static int getSum(int n)
    {
        return ( (n * (n+1)) / 2 );
    }
}
