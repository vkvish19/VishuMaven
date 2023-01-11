package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsomorphicStrings
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            System.out.println("Are strings isomorphic : " + areStringsIsomorphic(s1, s2));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean areStringsIsomorphic(String s1, String s2)
    {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}
