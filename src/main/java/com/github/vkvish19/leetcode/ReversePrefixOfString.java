package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversePrefixOfString
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String word = br.readLine();
            char ch = br.readLine().toCharArray()[0];
            System.out.println(reversePrefix(word, ch));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static String reversePrefix(String word, char ch)
    {
        if(word.indexOf(ch) != -1)
        {
            int index = word.indexOf(ch);
            StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
            sb.reverse();
            sb.append(word.substring(index + 1));
            return sb.toString();
        }
        return word;
    }
}
