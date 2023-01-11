package com.github.vkvish19.java8;

import java.util.Arrays;
import java.util.List;

public class FindMaxInListUsingJava8
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4, 6, 1, 4, 31, 7, 9, 10, 10, 10, 0, 9, 1, 1, 2);
        list.stream()
                .max(Integer::compare)
                .ifPresent(System.out::println);
    }
}
