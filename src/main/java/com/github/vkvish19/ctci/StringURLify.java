package com.github.vkvish19.ctci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringURLify
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                String str = br.readLine();
                System.out.println("URLify version of '" + str + "' is -> '" + getURLifiedString(str) + "'");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static String getURLifiedString(String str)
    {
        str = str.trim();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++)
        {
            if(chars[i] == ' ')
                sb.append("%20");
            else
                sb.append(chars[i]);
        }
        return sb.toString();
    }
}
