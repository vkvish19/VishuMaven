package com.github.vkvish19.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidString
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        
        System.out.println( printIsStringSherlockValid(inputString) );
    }
    
    private static String printIsStringSherlockValid(String str)
    {
        Map<Character,Integer> map = new HashMap<>();
        int len = str.length();
        for(int i = 0; i < len; i++)
        {
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 0);
            
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        
        boolean isValid = true;
        int n = map.get( str.charAt(0) );
        for(int i : map.values())
        {
            if(i != n)
                isValid = false;
        }
        
        if(isValid)
        {
            return "YES";
        }
        
        for(int i=0; i<str.length(); i++)
        {
            isValid = true;
            map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
            n = map.get(str.charAt(0));
            for(int t : map.values())
            {
                if(t != n && t > 0)
                {
                    isValid = false;
                }
            }
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
    
            if(isValid)
                return "YES";
        }
        return "NO";
    }
}
