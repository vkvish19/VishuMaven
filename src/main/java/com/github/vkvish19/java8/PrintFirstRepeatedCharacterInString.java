package com.github.vkvish19.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintFirstRepeatedCharacterInString
{
    public static void main(String[] args)
    {
        String s = "Java Hungry Blog Alive is Awesome";
        s.chars()
                .mapToObj(c -> Character.toLowerCase((char)c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(c -> System.out.println("First Repeating Character : " + c));
    }
}
