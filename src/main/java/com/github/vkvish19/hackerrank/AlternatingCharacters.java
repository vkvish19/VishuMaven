package com.github.vkvish19.hackerrank;

import java.util.Scanner;

public class AlternatingCharacters
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++)
        {
            System.out.println( getDeletionCountForAlternatingCharacters(sc.next()) );
        }
        
    }
    
    // AABAAB
    private static int getDeletionCountForAlternatingCharacters(String s)
    {
        int len = s.length();
        int deletionCount = 0;
        for(int i=0; i<len-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
                deletionCount++;
        }
        return deletionCount;
    }
}
