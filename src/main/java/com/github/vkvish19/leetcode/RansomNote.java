package com.github.vkvish19.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote
{
    public static void main(String[] args)
    {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println("constructRansomNote = " + constructRansomNote(ransomNote, magazine));
        System.out.println("canConstructRansomNoteEfficient = " + canConstructRansomNoteEfficient(ransomNote, magazine));
    }
    
    public static boolean constructRansomNote(String ransomNote, String magazine)
    {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for(char c : magazine.toCharArray())
        {
            if(magazineMap.containsKey(c))
                magazineMap.put(c, magazineMap.get(c) + 1);
            else 
                magazineMap.put(c, 1);
        }
        boolean canConstruct = true;
        for(char c : ransomNote.toCharArray())
        {
            if(!magazineMap.containsKey(c) || magazineMap.get(c) == 0)
            {
                canConstruct = false;
                break;
            }
            else 
                magazineMap.put(c, magazineMap.get(c) - 1);
        }
        return canConstruct;
    }
    
    public static boolean canConstructRansomNoteEfficient(String ransomNote, String magazine)
    {
        int[] hash = new int[26];
        for(char c : magazine.toCharArray())
            ++hash[c-'a'];
        for(char c : ransomNote.toCharArray())
            if(--hash[c-'a'] < 0)
                return false;
        return true;
    }
}
