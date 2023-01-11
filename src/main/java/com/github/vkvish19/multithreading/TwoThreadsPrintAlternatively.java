package com.github.vkvish19.multithreading;

import java.util.Scanner;

/**
 * We will have 2 threads, Thread t1 will print only odd numbers, Thread t2 will print only even numbers.
 * But we want the output to be printed in natural integer order (1,2,3,4,5,...)
 * We will also be given a number N, till which we need to print the numbers.
 */
public class TwoThreadsPrintAlternatively
{
    private int counter = 1;
    private static int N;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        TwoThreadsPrintAlternatively ttpa = new TwoThreadsPrintAlternatively();
        Thread t1 = new Thread(ttpa::printEven);
        Thread t2 = new Thread(ttpa::printOdd);
        
        t1.start();
        t2.start();
    }
    
    public void printOdd()
    {
        synchronized(this)
        {
            while(counter < N)
            {
                while(counter % 2 != 0)
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
                notify();
            }
        }
    }
    
    public void printEven()
    {
        synchronized(this)
        {
            while(counter < N)
            {
                while(counter % 2 == 0)
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
                notify();
            }
        }
    }
}
