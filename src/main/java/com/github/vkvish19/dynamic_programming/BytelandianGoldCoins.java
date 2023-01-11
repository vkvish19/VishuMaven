package com.github.vkvish19.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BytelandianGoldCoins
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int noOfTestCases = Integer.parseInt(br.readLine());
            for(int i = 0; i < noOfTestCases; i++)
            {
                int n = Integer.parseInt(br.readLine());
                System.out.println(solve(n));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int solve(int n)
    {
        if(n <= 0)
            return 0;
        if(n ==  1)
            return 1;
        int sum = solve(n/2) + solve(n/3) + solve(n/4);
        return Math.max(sum, n);
    }
}
