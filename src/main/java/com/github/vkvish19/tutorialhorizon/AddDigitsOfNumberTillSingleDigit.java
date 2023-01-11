package com.github.vkvish19.tutorialhorizon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AddDigitsOfNumberTillSingleDigit
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<Integer.MAX_VALUE; i++)
        {
            map.put("a-"+i, i);
        }
        System.out.println("map.size() = " + map.size());
        for(int i=0; i<10;i++)
        {
            map.put("a1-"+i, i);
        }
        System.out.println("map.size() = " + map.size());
    }
}
