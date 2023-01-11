package com.github.vkvish19.ctci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringCharactersUniqueness
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                String str = br.readLine();
                System.out.println(str + " : " + areCharactersUniqueUsingSTL(str));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean areCharactersUnique(String str)
    {
        int checker = 0;
        for(int i=0; i<str.length(); i++)
        {
            int value = str.charAt(i) - 'a';
            if((checker & (1 << value)) > 0)
            {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }
    
    public static boolean areCharactersUniqueUsingSTL(String str)
    {
        Arrays.sort(str.toCharArray());
        for(int i=0; i<str.length()-1; i++)
        {
            if(str.charAt(i) == str.charAt(i+1))
            {
                return false;
            }
        }
        return true;
    }
}
