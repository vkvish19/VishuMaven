package com.github.vkvish19.leetcode;

public class LinkedListCycle2
{
    public static void main(String[] args)
    {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2, l11);
        ListNode l13 = new ListNode(3, l12);
        ListNode l14 = new ListNode(4, l13);
        ListNode l15 = new ListNode(5, l14);
        ListNode l16 = new ListNode(6, l15);
        ListNode l17 = new ListNode(7, l16);
        
        l11.next = l14;
        
        ListNode loopNode = detectCycleStartingNode(l17);
        System.out.println(loopNode == null ? null : loopNode.val);
    }
    
    public static ListNode detectCycleStartingNode(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
    
        slow = slow.next;
        fast = fast.next.next;

        while(fast != null && fast.next != null)
        {
            if(slow == fast)
                break;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // no loop present
        if(slow != fast)
        {
            return null;
        }
        
        slow = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
