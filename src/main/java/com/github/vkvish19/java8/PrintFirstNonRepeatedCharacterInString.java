package com.github.vkvish19.java8;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintFirstNonRepeatedCharacterInString
{
    public static void main(String[] args)
    {
        String s = "Java Hungry Blog Alive is Awesome";
        Character firstNonRepeatingCharacter = s.chars()
                .mapToObj(c -> Character.toLowerCase((char)c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    
        System.out.println("firstNonRepeatingCharacter = " + firstNonRepeatingCharacter);
    }
}
