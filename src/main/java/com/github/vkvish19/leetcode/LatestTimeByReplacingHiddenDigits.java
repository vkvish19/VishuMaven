package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LatestTimeByReplacingHiddenDigits
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                String time = br.readLine();
                System.out.println("latestTimeByReplacingHiddenDigits(time) = " + latestTimeByReplacingHiddenDigits(time));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static String latestTimeByReplacingHiddenDigits(String time)
    {
        char[] ch = time.toCharArray();
        if(ch[0] == '?')
        {
            if(ch[1] == '?' || ch[1] == '0' || ch[1] == '1' || ch[1] == '2' || ch[1] == '3')
                ch[0] = '2';
            else
                ch[0] = '1';
        }
        
        if(ch[1] == '?' && ch[0] == '2')
            ch[1] = '3';
        if(ch[1] == '?' && (ch[0] == '0' || ch[0] == '1'))
            ch[1] = '9';
        
        if(ch[3] == '?')
            ch[3] = '5';
        
        if(ch[4] == '?')
            ch[4] = '9';
        
        return new String(ch);
    }
}
