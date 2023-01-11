package com.github.vkvish19.leetcode;

import java.util.Scanner;

public class ClimbingStairs
{
    public static void main(String[] args)
    {
        System.out.print("Enter value for 'n' : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
    
        int distinctWaysToClimb = getDistinctWaysToClimbNStairs(n);
        System.out.println("distinctWaysToClimb = " + distinctWaysToClimb);
    }
    
    // using DP
    // T : o(n)
    // S : o(n)
    public static int getDistinctWaysToClimbNStairs(int n)
    {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int[] distinctWays = new int[n];
        distinctWays[0] = 1;
        distinctWays[1] = 2;
        for(int i=3; i<=n; i++)
        {
            distinctWays[i-1] = distinctWays[i-2] + distinctWays[i-3];
        }
        return distinctWays[n-1];
    }
}
