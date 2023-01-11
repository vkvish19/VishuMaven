package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateIntegersInList
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4, 6, 1, 4, 7, 9, 10, 10, 10, 0, 9, 1, 1, 2);
        Set<Integer> uniqueIntegers = new HashSet<>();
        list.stream()
                .filter(n -> !uniqueIntegers.add(n))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        
    }
    
}
