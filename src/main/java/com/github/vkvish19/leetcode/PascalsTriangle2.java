package com.github.vkvish19.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle2
{
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(System.in))
        {
            int N = sc.nextInt();
            for(int i=0; i<N; i++)
            {
                int rowIndex = sc.nextInt();
                System.out.println("Pascal's Triangle for row '" + rowIndex + "' is : " + getPascalTriangleRow(rowIndex));
            }
        }
    }
    
    public static List<Integer> getPascalTriangleRow(int rowIndex)
    {
        // Base Case
        Integer[] row = new Integer[rowIndex + 1]; // Note: Using Array over a List bumps this up to 100% faster
        row[0] = 1;
    
        if(rowIndex == 0)
            return Arrays.asList(row);
    
        for(int i = 1; i <= rowIndex; i++) {
        
            // Add each element to current row
            for(int j = i; j > 0; j--) {
            
                // Handle edges
                if(j == i)
                    row[j] = 1;
                else { // Add Elements: c(j) = p(j) + p(j-1)
                    row[j] = row[j] + row[j-1];
                }
            }
        }
        return Arrays.asList(row);
    }
}
