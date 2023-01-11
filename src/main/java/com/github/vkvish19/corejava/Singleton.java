package com.github.vkvish19.corejava;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable
{
    private static volatile Singleton inst;
    
    private Singleton() throws Exception
    {
        if(inst != null)
        {
            System.out.println("Exception : Already initialized...");
            throw new Exception("Already initialized...");
        }
    }
    
    protected Object readResolve()
    {
        return inst;
    }
    
    @Override
    protected Singleton clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Already initialized singleton object...");
    }

    public static synchronized Singleton getInstance() throws Exception
    {
        if(inst == null)
            inst = new Singleton();
        return inst;
    }
}
