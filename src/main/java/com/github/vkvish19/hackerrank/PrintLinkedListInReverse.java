package com.github.vkvish19.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PrintLinkedListInReverse
{
    static class SinglyLinkedListNode
    {
        public int data;
        public SinglyLinkedListNode next;
        
        public SinglyLinkedListNode(int nodeData)
        {
            this.data = nodeData;
            this.next = null;
        }
    }
    
    static class SinglyLinkedList
    {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;
        
        public SinglyLinkedList()
        {
            this.head = null;
            this.tail = null;
        }
        
        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            
            if(this.head == null)
            {
                this.head = node;
            }
            else
            {
                this.tail.next = node;
            }
            
            this.tail = node;
        }
    }
    
    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep)
    {
        while(node != null)
        {
            System.out.print(node.data);
            
            node = node.next;
            
            if(node != null)
            {
                System.out.print(sep);
            }
        }
    }
    
    // using StringBuilder and string split
    static void reversePrintUsingStringBuilder(SinglyLinkedListNode head)
    {
        StringBuilder sb = new StringBuilder();
        while(head != null)
        {
            sb.append(head.data).append(",");
            head = head.next;
        }
        
        String[] out = sb.toString().split(",");
        int len = out.length;
        System.out.println("reversePrintUsingStringBuilder:-");
        for(int i=len-1; i>=0; i--)
        {
            System.out.println(out[i]);
        }
    }
    
    // using stack
    static void reversePrintUsingStack(SinglyLinkedListNode head)
    {
        if(stack == null)
            stack = new Stack<>();
        while(head != null)
        {
            stack.push(head.data);
            head = head.next;
        }
        System.out.println("reversePrintUsingStack:-");
        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    private static Stack<Integer> stack = null;
    
    /**
     * sample input
     * 1
     * 5
     * 16
     * 12
     * 4
     * 2
     * 5
     *
     * sample output
     * 5
     * 2
     * 4
     * 12
     * 16
     */

    public static void main(String[] args)
    {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for(int testsItr = 0; testsItr < tests; testsItr++)
        {
            SinglyLinkedList llist = new SinglyLinkedList();
            
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for(int i = 0; i < llistCount; i++)
            {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
                llist.insertNode(llistItem);
            }
            
            reversePrintUsingStringBuilder(llist.head);
            reversePrintUsingStack(llist.head);
        }
        
        scanner.close();
    }
}