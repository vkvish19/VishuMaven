package com.github.vkvish19.multithreading;

import java.util.Scanner;

public class ThreeThreadsPrintingAlternatively
{
    static int N;
    int counter = 1;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        ThreeThreadsPrintingAlternatively ttpa = new ThreeThreadsPrintingAlternatively();
        Thread t1 = new Thread(ttpa::print1);
        Thread t2 = new Thread(ttpa::print2);
        Thread t3 = new Thread(ttpa::print3);
        
        t1.start();
        t2.start();
        t3.start();
    }
    
    public void print1()
    {
        synchronized(this)
        {
            while(counter < N)
            {
                while(counter % 3 == 0)
                {
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notifyAll();
            }
        }
    }
    
    public void print2()
    {
        synchronized(this)
        {
            while(counter < N)
            {
                while(counter % 3 == 1)
                {
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notifyAll();
            }
        }
    }
    
    public void print3()
    {
        synchronized(this)
        {
            while(counter < N)
            {
                while(counter % 3 == 2)
                {
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notifyAll();
            }
        }
    }
}
