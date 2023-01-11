package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.List;

public class FindAllNumbersStartingWith1
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1001, 100000, 111, 6, 7, 8, 9, 10, 12, 14, 7, 3);
        
        // this was my initial code snippet
        System.out.println("Initial try : ");
        list.stream()
                .map(String::valueOf)
                .map(s -> new StringBuilder(s).reverse())
                .filter(s -> s.lastIndexOf("1") == s.length() - 1)
                .map(s -> new StringBuilder(s).reverse())
                .forEach(s -> System.out.print(s +" "));
        
        // proper/optimized/correct code snippet
        System.out.println("\nOptimized : ");
        list.stream()
                .map(n -> n+"")
                .filter(s -> s.startsWith("1"))
                .forEach(s -> System.out.print(s +" "));
    }
}
