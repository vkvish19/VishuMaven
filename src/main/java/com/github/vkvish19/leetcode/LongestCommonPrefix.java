package com.github.vkvish19.leetcode;

public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        String[] strings = {"flower","flow","flight"};
        String longestCommonPrefix = getLongestCommonPrefix(strings);
        System.out.println("longestCommonPrefix = " + longestCommonPrefix);
    }
    
    public static String getLongestCommonPrefix(String[] strings)
    {
        String prefix = strings[0];
        for(int i=1; i< strings.length; i++)
        {
            while(strings[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
