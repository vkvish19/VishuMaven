package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortIntegerListUsingJava8
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4, 6, 1, 4, 31, 7, 9, 10, 10, 10, 0, 9, 1, 1, 2);
        System.out.print("Unsorted list : ");
        list.forEach(s -> System.out.print(s+" "));
        System.out.print("\nSorted list In ASC order: ");
        list.stream().sorted().forEach(s -> System.out.print(s+" "));
        System.out.print("\nSorted list In DESC order (using custom comparator) : ");
        list.stream().sorted(new DescendingOrderComparator()).forEach(s -> System.out.print(s+" "));
        System.out.print("\nSorted list In DESC order : ");
        list.stream().sorted(Collections.reverseOrder()).forEach(s -> System.out.print(s+" "));
    }
}

class DescendingOrderComparator implements Comparator<Integer>
{
    
    @Override
    public int compare(Integer o1, Integer o2)
    {
        return o2.compareTo(o1);
    }
}