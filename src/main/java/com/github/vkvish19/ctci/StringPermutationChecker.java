package com.github.vkvish19.ctci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringPermutationChecker
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                String s1 = br.readLine();
                String s2 = br.readLine();
                System.out.println("Are '" + s1 + "' and '" + s2 + "' permutable -> " + areStringsPermutable(s1, s2));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean areStringsPermutable(String s1, String s2)
    {
        boolean arePermutable = true;
        if(s1.length() != s2.length())
            arePermutable = false;
        else
        {
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();
            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);
            for(int i=0; i< s1Arr.length; i++)
            {
                if(s1Arr[i] != s2Arr[i])
                {
                    arePermutable = false;
                    break;
                }
            }
        }
        return arePermutable;
    }
}
