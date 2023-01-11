package com.github.vkvish19.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallestMissingPositiveInteger
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String[] sarr = br.readLine().split(" ");
            int[] arr = new int[sarr.length];
            List<Integer> list = new ArrayList<>();
            int index = 0;
            for(String s : sarr)
            {
                int num = Integer.parseInt(s);
                // add to list
                list.add(num);

                // add to array
                arr[index] = num;
                index++;
            }
            int smallestMissingPositiveInteger = getSmallestMissingPositiveInteger(list);
            System.out.println("smallestMissingPositiveInteger using List = " + smallestMissingPositiveInteger);
            int smallestIntUsingArray = getSmallestMissingPositiveInteger(arr);
            System.out.println("smallestMissingPositiveInteger using array and O(N) time, O(1) space complexity = " + smallestIntUsingArray);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    // this is useful if List is provided
    // not useful if array is provided and O(N) time & O(1) space complexity is asked.
    protected static int getSmallestMissingPositiveInteger(List<Integer> list)
    {
        int smallestMissingPositiveInteger = -1;
        for(int i = 1; i < Integer.MAX_VALUE; i++)
        {
            if(!list.contains(i))
            {
                smallestMissingPositiveInteger = i;
                break;
            }
        }
        return smallestMissingPositiveInteger;
    }
    
    protected static int getSmallestMissingPositiveInteger(int[] arr)
    {
        int i = 0;
        int len = arr.length;
        while(i < len)
        {
            int correct = arr[i] - 1;   // bcoz of Zero based indexing
            
            // if ith element is within range [1,N] and at wrong index, we swap the elements.
            if(arr[i]>0 && arr[i]<=len && arr[i]!=arr[correct])
            {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else
            {
                // else we skip
                i++;
            }
        }
        
        //we iterate over the array again to find our missing integer.
        for(int j=0; j<len; j++)
        {
            // if our # (index+1) is present in array, it will be in the indexTH position
            if(arr[j] != j+1)
                return j+1;
        }
        return len+1;    // if all elements present then our answer will be array length + 1.
    }
}
