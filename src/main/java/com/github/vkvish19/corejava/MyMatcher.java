package com.github.vkvish19.corejava;

public class MyMatcher implements Matcher
{
    public MyMatcher()
    {
        System.out.println("MyMatcher constructor called.");
    }
    
    @Override
    public void check()
    {
        System.out.println("check in MyMatcher.");
    }
}
