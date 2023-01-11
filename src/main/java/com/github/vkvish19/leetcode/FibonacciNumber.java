package com.github.vkvish19.leetcode;

import java.util.Scanner;

public class FibonacciNumber
{
    public static void main(String[] args)
    {
        System.out.print("Enter value for 'n' : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        long nthFibonacciNumber = getNthFibonacciNumber(n);
        System.out.println("nthFibonacciNumber = " + nthFibonacciNumber);
    }
    
    public static long getNthFibonacciNumber(int n)
    {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        
        int[] fs = new int[n+1];
        fs[0] = 0;
        fs[1] = 1;
        for(int i=2; i<=n; i++)
        {
            fs[i] = fs[i-2] + fs[i-1];
        }
        return fs[n];
    }
}
