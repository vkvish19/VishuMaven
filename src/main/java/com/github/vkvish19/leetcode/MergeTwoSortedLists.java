package com.github.vkvish19.leetcode;

public class MergeTwoSortedLists
{
    public static void main(String[] args)
    {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        
        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(1, l22);
        
        ListNode mergedList = mergeTwoSortedLists(l11, l21);
        
        // printing the merged list elements
        while(mergedList != null)
        {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        
    }
    
    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
    
        if(l2 == null)
            return l1;
    
        ListNode outHead = new ListNode(0);
        ListNode prev;
        prev = outHead;
    
        while(l1 != null && l2 != null)
        {
            ListNode out;
            if(l1.val <= l2.val)
            {
                out = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                out = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev.next = out;
            prev = out;
        }
    
        if(l1 != null)
        {
            prev.next = l1;
        }
        else
        {
            prev.next = l2;
        }
    
        return outHead.next;
    }
}
