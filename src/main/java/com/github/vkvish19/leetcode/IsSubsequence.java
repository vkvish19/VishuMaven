package com.github.vkvish19.leetcode;

public class IsSubsequence
{
    public static void main(String[] args)
    {
        String s = "abc";
        String t = "ahbgdc";
        boolean isSubsequence = isSubsequence(s, t);
        System.out.println("isSubsequence = " + isSubsequence);
    }
    
    public static boolean isSubsequence(String s, String t)
    {
        if(s.equals(t))
            return true;
        
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
