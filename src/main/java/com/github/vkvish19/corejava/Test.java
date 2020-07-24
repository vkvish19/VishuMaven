package com.github.vkvish19.corejava;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test
{
    public static void main(String[] args)
    {
        String s = "test:secret";
        String c = Base64.getEncoder().encodeToString(s.getBytes());
        System.out.println("c = " + c);
        byte[] b = Base64.getDecoder().decode("czZCaGRSa3F0MzpnWDFmQmF0M2JW");
        String ss = new String(b);
        System.out.println("ss = " + ss);
    }
    
    @SuppressWarnings("rawtypes")
    public static Matcher getMatcher(String matcherType)
    {
        try
        {
            Class handler = Class.forName(matcherType);
            return (Matcher) handler.newInstance();
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
            System.out.println("Exception : " + e);
        }
        return null;
    }
    
}