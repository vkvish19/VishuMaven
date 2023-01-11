package com.github.vkvish19.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal
{
    public static void main(String[] args)
    {
        TreeNode n135 = new TreeNode(5);
        TreeNode n136 = new TreeNode(6);
        
        List<TreeNode> list3 = new ArrayList<>();
        list3.add(n135);
        list3.add(n136);
    
        TreeNode n13 = new TreeNode(3, list3);
        TreeNode n12 = new TreeNode(2);
        TreeNode n14 = new TreeNode(4);
    
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(n13);
        list1.add(n12);
        list1.add(n14);
        
        TreeNode n1 = new TreeNode(1, list1);
        
        List<Integer> output = preOrderUsingRecursion(n1);
        System.out.println("preOrderUsingRecursion = " + output);
    
        System.out.println("preOrderUsingIteration = " + preOrderUsingIteration(n1));
    }
    
    public static List<Integer> preOrderUsingIteration(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
    
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.empty())
        {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.children != null)
            {
                for(int i=node.children.size()-1; i>=0; i--)
                {
                    stack.add(node.children.get(i));
                }
            }
        }
        return list;
    }
    
    public static List<Integer> preOrderUsingRecursion(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        addToPreorderList(root, result);
        return result;
    }

    public static void addToPreorderList(TreeNode node, List<Integer> list)
    {
        if(node == null)
            return;
        list.add(node.val);
        if(node.children != null)
        {
            for(TreeNode node1 : node.children)
            {
                addToPreorderList(node1, list);
            }
        }
    }
}
