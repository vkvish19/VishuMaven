package com.github.vkvish19.corejava;


public class ZipInputStreamTest
{
    public static void main(String[] args)
    {
        A b = new B();
    }
}

class A
{
    A()
    {
        System.out.println("empty A");
        haha();
    }
    
    void haha()
    {
        System.out.println("haha A");
    }
}

class B extends A{
    B()
    {
        super();
        System.out.println("empty B");
    }
    
    @Override
    void haha()
    {
        System.out.println("haha B");
    }
}
