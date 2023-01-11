package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.List;

public class PrintFirstElementInList
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4, 6, 1, 4, 7, 9, 10, 10, 10, 0, 9, 1, 1, 2);
        printFirstElementInList(list);
    }

    public static void printFirstElementInList(List<Integer> list)
    {
        
        // get the 1st element of the list
        list.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
