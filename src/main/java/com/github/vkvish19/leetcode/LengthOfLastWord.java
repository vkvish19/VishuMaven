package com.github.vkvish19.leetcode;

public class LengthOfLastWord
{
    public static void main(String[] args)
    {
        String s = "     ha haha haa hello world             ";
        int len = lengthOfLastWordInString(s);
        System.out.println(len);
    }
    
    public static int lengthOfLastWordInString(String s)
    {
        String[] sarr = s.trim().split(" ");
        return sarr[sarr.length-1].length();
    }
}
