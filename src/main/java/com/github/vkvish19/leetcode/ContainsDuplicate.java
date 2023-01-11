package com.github.vkvish19.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("{1, 2, 3, 4, 5, 6, 7, 8, 9} - containsDuplicate = " + containsDuplicate(nums1));
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("{1, 2, 3, 1} - containsDuplicate = " + containsDuplicate(nums2));
        int[] nums3 = {1};
        System.out.println("{1} - containsDuplicate = " + containsDuplicate(nums3));
    }
    
    public static boolean containsDuplicate(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
        {
            if(map.containsKey(i))
                return true;
            map.put(i, 1);
        }
        return false;
    }
}
