package com.github.vkvish19.leetcode;

import java.util.Scanner;

public class SqrtOfX
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        System.out.println("sqrt(n) = " + squareRoot(sc.nextInt()));
        sc.close();
    }
    
    private static int squareRoot(int x)
    {
        if (x < 2) return x;
    
        long left = 1;
        long right = x;
        while(left < right) {
            long mid = ((left + right) / 2);
            if (mid*mid > x) {
                right = mid;
            }
            else if (mid*mid < x) {
                left = mid + 1;
            }
            else return (int)(mid);
        }
        return (int)(--left);
    }
}
