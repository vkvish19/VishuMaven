package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidPalindrome
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String input = br.readLine();
            System.out.println(isValidPalindrome(input));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean isValidPalindrome(String input)
    {
//        input = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int start = 0;
        int end = input.length()-1;
        char startChar;
        char endChar;
        char[] arr = input.toLowerCase().toCharArray();
        while(start<end)
        {
            startChar = arr[start];
            endChar = arr[end];
            if(!Character.isLetterOrDigit(startChar))
            {
                start++;
            }
            else if(!Character.isLetterOrDigit(endChar))
            {
                end--;
            }
            else if(startChar != endChar)
                return false;
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}
