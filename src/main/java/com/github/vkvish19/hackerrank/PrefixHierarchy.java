package com.github.vkvish19.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixHierarchy
{
    public static void main(String[] args)
    {
        String[] sarr = {"jackson", "jacques", "jack"};
        String[] prefixes = {"jack"};
        List<Integer> myCount = findCompletePrefixes(Arrays.asList(sarr), Arrays.asList(prefixes));
        for(Integer integer : myCount)
        {
            System.out.println(integer);
        }
    }
    
    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query)
    {
        List<Integer> count = new ArrayList<>();

        // if input is null or empty then count should be zero.
        if(names == null || names.isEmpty())
        {
            for(int i=0; i< query.size(); i++)
            {
                count.add(0);
            }
            return count;
        }
        
        for(String pref : query)
        {
            int prefCount = 0;
            for(String s : names)
            {
                if(s.length() <= pref.length() || !s.startsWith(pref))
                    continue;
                
                prefCount++;
            }
            count.add(prefCount);
        }
        return count;
    }
}
