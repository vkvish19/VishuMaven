package com.github.vkvish19.datastructures.linkedlist;

public class MySinglyLinkedList
{
    Node head;
//    Node<E> last;
    
    private static class Node
    {
        int data;
        Node next;
//        Node prev;
        
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    // add element at last
    public void add(int data)
    {
        Node newNode = new Node(data, null);
        if(head == null)
        {
            head = newNode;
        }
        else 
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    // remove element at head
    public void remove()
    {
        if(head != null)
            head = head.next;
    }
    
    //remove element at given index
    public void remove(int index)
    {
        int i = 0;
        Node temp = head;
        while(temp != null)
        {
            if((temp.next != null) && (i == index-1))
            {
                temp.next = temp.next.next;
                break;
            }
            else 
            {
                temp = temp.next;
                i++;
            }
        }
    }
    
    @Override
    public String toString()
    {
        if(head == null)
            return null;
        
        StringBuilder sb = new StringBuilder();
        Node t = head;
        sb.append('[');
        while(t != null)
        {
            sb.append(t.data);
            t = t.next;
            if(t != null)
                sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
    
    public void addFirst(int data)
    {
        if(head == null)
            head = new Node(data, null);
        else
        {
            Node oldHead = head;
            head = new Node(data, oldHead);
        }
    }
    
    public void removeLast()
    {
        if(head != null)
        {
            if(head.next == null)
                head = null;
            else
            {
                Node t = head;
                while(t.next.next != null)
                {
                    t = t.next;
                }
                t.next = null;
            }
        }
    }
    
    public void removeAll()
    {
        head = null;
    }
    
    public void update(int index, int data)
    {}
}
