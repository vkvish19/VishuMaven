package com.github.vkvish19.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String parenthesesString = sc.next();
        boolean isValid = isValidParentheses(parenthesesString);
        System.out.println("isValid = " + isValid);
        sc.close();
    }
    
    public static boolean isValidParentheses(String parentheses)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<parentheses.length(); i++)
        {
            char curr = parentheses.charAt(i);
            if(curr == '[' || curr == '{' || curr == '(')
                stack.add(curr);
            else
            {
                if(stack.isEmpty())
                    return false;
                if(
                        (curr == ')' && stack.peekLast() == '(')
                                || (curr == '}' && stack.peekLast() == '{')
                                || (curr == ']' && stack.peekLast() == '[')
                )
                    stack.pollLast();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
