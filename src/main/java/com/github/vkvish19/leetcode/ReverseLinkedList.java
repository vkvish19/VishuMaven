package com.github.vkvish19.leetcode;

import java.util.Stack;

public class ReverseLinkedList
{
    public static void main(String[] args)
    {
        ListNode l15 = new ListNode(5);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        
        ListNode reversedList = reverseListUsingRecursion(l11);
        
        // printing the merged list elements
        while(reversedList != null)
        {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
    
    public static ListNode reverseListUsingRecursion(ListNode l1)
    {
        if(l1 == null || l1.next == null)
        {
            return l1;
        }
        ListNode res = reverseListUsingRecursion(l1.next);
        l1.next.next = l1;
        l1.next = null;
        return res;
    }
}

