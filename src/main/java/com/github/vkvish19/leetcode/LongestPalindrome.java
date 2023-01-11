package com.github.vkvish19.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome
{
    public static void main(String[] args)
    {
        String s = "abccccdd";
        int longestPalindromeLengthUsingHashSet = longestPalindromeLengthUsingHashSet(s);
        System.out.println("longestPalindromeLengthUsingHashSet = " + longestPalindromeLengthUsingHashSet);
        int longestPalindromeLengthUsingFrequencyArray = longestPalindromeLengthUsingFrequencyArray(s);
        System.out.println("longestPalindromeLengthUsingFrequencyArray = " + longestPalindromeLengthUsingFrequencyArray);
    }
    
    public static int longestPalindromeLengthUsingHashSet(String s)
    {
        if(s == null || s.isEmpty())
            return 0;
        
        int len = 0;
        Set<Character> set = new HashSet<>();
        for(int idx = 0; idx < s.length(); idx++)
        {
            char ch = s.charAt(idx);
            if(set.contains(ch))
            {
                len += 2;
                set.remove(ch);
            }
            else
            {
                set.add(ch);
            }
        }
        if(!set.isEmpty())
        {
            len++;
        }
        return len;
    }
    
    public static int longestPalindromeLengthUsingFrequencyArray(String s)
    {
        if(s == null || s.isEmpty())
            return 0;
        
        int[] freq = new int[128];
        int len = 0;
        for(int idx=0; idx<s.length(); idx++)
        {
            freq[s.charAt(idx)]++;
        }
        for(int count : freq)
        {
            len += 2 * (count/2);
        }
        return len<s.length() ? len+1 : len;
    }
}
