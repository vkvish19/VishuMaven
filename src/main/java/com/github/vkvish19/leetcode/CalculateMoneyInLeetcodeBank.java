package com.github.vkvish19.leetcode;

import java.util.Scanner;

public class CalculateMoneyInLeetcodeBank
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for n : ");
        System.out.println("VISHU :: totalMoney = "  + totalMoney(sc.nextInt()));
        sc.close();
    }
    
    private static int totalMoney(int n)
    {
        int numberOfCompleteWeeks = n/7;
        int remainingDays = n%7;
        int startValueForLastWeek = numberOfCompleteWeeks + 1;
        int sum = remainingDays * (2*startValueForLastWeek + remainingDays - 1) + 7 * numberOfCompleteWeeks * (2*4 + numberOfCompleteWeeks - 1);
        return sum/2;
    }
}
