package com.github.vkvish19.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableOfContents
{
    public static void main(String[] args)
    {
        List<String> input = Arrays.asList("# Cars",
                "Cars came into global",
                "20th century",
                "Most definitions of car",
                "primarily on roads",
                "## Sedan",
                "Sedan's first recorded",
                "for a car body",
                "## Coupe",
                "A coupe is a ",
                "sloping rear roofline",
                "two doors",
                "## SUV",
                "The passenger",
                "# Airplanes",
                "the late 1930s",
                "There is no commonly",
                "## JetAirways",
                "countries"
        );
        
        List<String> tableOfContents = tableOfContents(input);
        for(String s : tableOfContents)
        {
            System.out.println(s);
        }
    }
    
    public static List<String> tableOfContents(List<String> text)
    {
        List<String> contents = new ArrayList<>();
        int mainNum = 0;
        int subNum = 1;
        for(String s: text)
        {
            if(s.startsWith("# "))
            {
                contents.add(++mainNum + "." + s.substring(1));
                subNum = 1;
            }
            
            if(s.startsWith("## "))
            {
                contents.add(mainNum + "." + subNum++ + "." + s.substring(2));
            }
            
        }
        return contents;
    }
}
