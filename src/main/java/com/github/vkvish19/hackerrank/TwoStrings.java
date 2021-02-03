package com.github.vkvish19.hackerrank;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T  = scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println( twoStrings(s1, s2) ? "YES" : "NO" );
        }
    }
    
    public static boolean twoStrings(String s1, String s2)
    {
        Set<Character> s1Set = new HashSet<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0; i<c1.length; i++)
        {
            s1Set.add(c1[i]);
        }
        for(int i=0; i<c2.length; i++)
        {
            if(s1Set.contains(c2[i]))
            {
                return true;
            }
        }
        return false;
    }
}
