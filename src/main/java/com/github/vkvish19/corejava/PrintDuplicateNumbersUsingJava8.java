package com.github.vkvish19.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintDuplicateNumbersUsingJava8
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String[] sarr = br.readLine().split(" ");
            int[] arr = new int[sarr.length];
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<sarr.length; i++)
            {
                arr[i] = Integer.parseInt(sarr[i]);
                list.add(Integer.parseInt(sarr[i]));
            }
            printDuplicatesBeforeJava8(arr);
            printDuplicatesUsingJava8(list);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void printDuplicatesBeforeJava8(int[] arr)
    {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for(int i=0; i<arr.length; i++)
        {
            if(set.contains(arr[i]))
            {
                duplicates.add(arr[i]);
            }
            else
            {
                set.add(arr[i]);
            }
        }
        System.out.println("duplicates using Java < 1.8 : " + duplicates);
    }
    
    public static void printDuplicatesUsingJava8(List<Integer> list)
    {
        System.out.println("duplicates using Java 8 : ");
        Set<Integer> set = new HashSet<>();
        list.stream()
                .filter(num -> !set.add(num))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
