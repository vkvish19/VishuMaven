package com.github.vkvish19.leetcode;

import java.util.Scanner;

public class PalindromeNumber
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in))
        {
            int n = sc.nextInt();   // number of test cases.
            for(int i=0; i<n; i++)
            {
                int num = sc.nextInt();
                System.out.println(isPalindrome(num));
            }
        }
    }
    
    private static boolean isPalindrome(int num)
    {
        if(num < 0)
            return false;
        
        int reversedNumber = 0;
        int sub = num;
        while(sub != 0)
        {
            reversedNumber = (reversedNumber*10) + (sub%10);
            sub /= 10;
        }
        return num == reversedNumber;
    }
}
