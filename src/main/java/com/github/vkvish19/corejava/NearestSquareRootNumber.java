package com.github.vkvish19.corejava;

import java.util.Scanner;

public class NearestSquareRootNumber
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of test cases you want to try : ");
        int testCasesCount = in.nextInt();
        for(int i=0; i<testCasesCount; i++)
        {
            System.out.print("Number : ");
            int num = in.nextInt();
            System.out.println("nearest Square Root Number for '" + num + "' = " + getNearestSquareRootForGivenNumber(num));
        }
        in.close();
    }
    
    protected static int getNearestSquareRootForGivenNumber(int n)
    {
        int diff = n;
        int m = 0;
        for(int z=1; z<=n/2 + 1; z++)
        {
            if(z*z == n)
                return z;
            else
            {
                int d = z*z - n;
                if(d < 0)
                    d *= -1;
                
                if(d <= diff)
                {
                    diff = d;
                    m = z;
                }
                if(d > diff)
                    break;
            }
        }
        return m;
    }
}
