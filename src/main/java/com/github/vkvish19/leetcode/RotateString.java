package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateString
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.print("Enter # of test cases : ");
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                String s = br.readLine();
                String goal = br.readLine();
                System.out.println("rotateMatchPossible : " + rotateMatchPossible(s, goal));
                System.out.println("rotateMatchPossibleBestSolution : " + rotateMatchPossibleBestSolution(s, goal));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean rotateMatchPossible(String s, String goal)
    {
        boolean isRotatePossible = false;
        if(s.length() != goal.length())
            return false;
        if(s.equals(goal))
            return true;
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            s = s.substring(1) + s.charAt(0);
            if(s.equals(goal))
            {
                isRotatePossible = true;
                break;
            }
        }
        return isRotatePossible;
    }
    
    public static boolean rotateMatchPossibleBestSolution(String s, String goal)
    {
        String tmp = s + s;
        int sLen = s.length();
        for(int i=0; i<=sLen; i++)
        {
            String substring = tmp.substring(i, i + sLen);
            if(substring.equals(goal))
                return true;
        }
        return false;
    }
}
