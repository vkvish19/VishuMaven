package com.github.vkvish19.leetcode;

public class MiddleOfLinkedList
{
    public static void main(String[] args)
    {
        ListNode l16 = new ListNode(6);
        ListNode l15 = new ListNode(5, l16);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
    
        ListNode middleNode = middleOfLinkedList(l11);
    
        while(middleNode != null)
        {
            System.out.print(middleNode.val + " ");
            middleNode = middleNode.next;
        }
    }
    
    public static ListNode middleOfLinkedList(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        if(head.next.next == null)
        {
            return head.next;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next != null && p1.next.next != null)
        {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        if(p1.next == null)
        {
            return p2;
        }
        return p2.next;
    }
}
