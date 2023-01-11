package com.github.vkvish19.leetcode;

public class MergeSortedArray
{
    public static void main(String[] args)
    {
        int[] a1 = {1};//{1, 2, 3, 4, 0, 0, 0};
        int[] a2 = {};//{2, 5, 6};
        
        int n = a2.length;
        int m = a1.length - n;
        mergeSortedArrays(a1, m, a2, n);
    
        for(int i=0; i<a1.length; i++)
        {
            System.out.print(a1[i] + " ");
        }
    }
    
    public static void mergeSortedArrays(int[] a1, int m, int[] a2, int n)
    {
        int i=0;
        int j=0;
        
        while(i<m)
        {
            if(a1[i] > a2[j])
            {
                int tmp = a1[i];
                a1[i] = a2[j];
                a2[j] = tmp;
            }
            i++;
        }
        
        while(j < n-1)
        {
            if(a2[j] <= a2[j+1])
            {
                a1[i++] = a2[j];
            }
            else
            {
                a1[i++] = a2[j+1];
                a2[j+1] = a2[j];
            }
            j++;
        }
        a1[i] = a2[j];
    }
}
