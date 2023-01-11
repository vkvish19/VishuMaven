package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringInPlace
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                char[] s = (br.readLine()).toCharArray();
                printReverseString(s);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void printReverseString(char[] s)
    {
        int len = s.length;
        int endLoop = (len + 1)/2;
        for(int i=0; i<endLoop; i++)
        {
            char tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
        System.out.println(new String(s));
    }
}
