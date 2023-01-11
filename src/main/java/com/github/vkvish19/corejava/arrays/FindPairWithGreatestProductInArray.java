package com.github.vkvish19.corejava.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGreatestProductInArray
{
    public static void main(String[] args)
    {
        System.out.println("Using Naive Method:-");
        System.out.println("Greatest for {10, 3, 5, 30, 35} : " + findGreatestUsingNaiveApproach(new int[] {10, 3, 5, 30, 35}));
        System.out.println("Greatest for {2, 5, 7, 8} : " + findGreatestUsingNaiveApproach(new int[] {2, 5, 7, 8}));
        System.out.println("Greatest for {10, 2, 4, 30, 35} : " + findGreatestUsingNaiveApproach(new int[] {10, 2, 4, 30, 35}));
        System.out.println("Greatest for {10, 2, 2, 4, 30, 35} : " + findGreatestUsingNaiveApproach(new int[] {10, 2, 2, 4, 30, 35}));
        System.out.println("Greatest for {17, 2, 1, 35, 30} : " + findGreatestUsingNaiveApproach(new int[] {17, 2, 1, 35, 30}));
        
        
        System.out.println("***********************************************************");
        System.out.println("Using Efficient Method:");
        System.out.println("Greatest for {10, 3, 5, 30, 35} : " + findGreatestUsingEfficientWay(new int[] {10, 3, 5, 30, 35}));
        System.out.println("Greatest for {2, 5, 7, 8} : " + findGreatestUsingEfficientWay(new int[] {2, 5, 7, 8}));
        System.out.println("Greatest for {10, 2, 4, 30, 35} : " + findGreatestUsingEfficientWay(new int[] {10, 2, 4, 30, 35}));
        System.out.println("Greatest for {10, 2, 2, 4, 30, 35} : " + findGreatestUsingEfficientWay(new int[] {10, 2, 2, 4, 30, 35}));
        System.out.println("Greatest for {17, 2, 1, 35, 30} : " + findGreatestUsingEfficientWay(new int[] {17, 2, 1, 35, 30}));
    }
    
    public static int findGreatestUsingNaiveApproach(int[] arr)
    {
        int max = -1;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - 1; j++)
            {
                for(int k = j + 1; k < arr.length; k++)
                {
                    if(arr[j]*arr[k] == arr[i])
                        max = Math.max(max, arr[i]);
                }
            }
        }
        return max;
    }
    
    public static int findGreatestUsingEfficientWay(int[] arr)
    {
        // store occurrences in hashmap
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(m.containsKey(arr[i]))
                m.put(arr[i], m.get(arr[i]) + 1);
            else
                m.put(arr[i], 1);
        }
        
        // sort the array and traverse all elements from the end
        Arrays.sort(arr);
        
        for(int i = arr.length - 1; i > 1; i--)
        {
            // for every element check if there is another element which divides it
            for(int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++)
            {
                if(arr[i]%arr[j] == 0)
                {
                    int result = arr[i]/arr[j];
                    // check if result value exists in array or not if yes then return arr[i]
                    if((result != arr[j] && m.containsKey(result))
                            // to handle the case like arr[i]=4 and arr[j]=2
                            || (result == arr[j] && m.containsKey(result) && m.get(result) > 1))
                    {
                        return arr[i];
                    }
                }
            }
        }
        return -1;
    }
}
