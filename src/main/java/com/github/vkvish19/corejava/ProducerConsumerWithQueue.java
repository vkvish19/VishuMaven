package com.github.vkvish19.corejava;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerWithQueue
{
    public static final Queue<Integer> QUEUE = new ArrayDeque<>();
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread producerThread = new Thread(new MyProducer());
        Thread consumerThread = new Thread(new MyConsumer());
        producerThread.start();
        consumerThread.start();
        
        producerThread.join();
        consumerThread.join();
        System.out.println("Exited the application successfully...");
    }
}

class MyProducer implements Runnable
{
    @Override
    public void run()
    {
        while(true)
        {
            synchronized(ProducerConsumerWithQueue.QUEUE)
            {
                if(ProducerConsumerWithQueue.QUEUE != null)
                {
                    int num = new Random().nextInt();
                    ProducerConsumerWithQueue.QUEUE.add(num);
                    System.out.println("Added num '" + num + "' to the queue at the Producer...");
                }
            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
}

class MyConsumer implements Runnable
{
    @Override
    public void run()
    {
        while(true)
        {
            synchronized(ProducerConsumerWithQueue.QUEUE)
            {
                if(!ProducerConsumerWithQueue.QUEUE.isEmpty())
                {
                    int num = ProducerConsumerWithQueue.QUEUE.poll();
                    System.out.println("Polled num '" + num + "' from the queue at the Consumer...");
                }
            }
        }
    }
}
