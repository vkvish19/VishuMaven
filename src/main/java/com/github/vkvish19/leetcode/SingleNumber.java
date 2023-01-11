package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleNumber
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
            System.out.println(getUniqueNumber(nums));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int getUniqueNumber(int[] nums)
    {
        int result = 0;
        for(int i=0; i<nums.length; i++)
        {
            result ^= nums[i];
            System.out.println("num = " + nums[i] + ", result = " + result);
        }
        return result;
    }
}
