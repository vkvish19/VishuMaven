package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.List;

public class PrintListSizeUsingJava8
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4, 6, 1, 4, 7, 9, 10, 10, 10, 0, 9, 1, 1, 2);
        printListSize(list);
    }
    
    public static void printListSize(List<Integer> list)
    {
        long size = list.stream()
                .count();
        System.out.println("size = " + size);
    }
}
