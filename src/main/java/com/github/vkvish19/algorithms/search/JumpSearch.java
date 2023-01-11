package com.github.vkvish19.algorithms.search;

public class JumpSearch
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 4, 4, 6, 8, 10, 11, 23, 45};    // array needs to be sorted for binary search
        int k = 11;
        int index = getIndexByJumpSearch(nums, k);
        System.out.println("index = " + index);
    }
    
    protected static int getIndexByJumpSearch(int[] arr, int k)
    {
        int n = arr.length;
        int m = (int)Math.floor(Math.sqrt(n));
        
        int prev = 0;
        
        // get the block
        while(arr[Math.min(m,n)-1] < k)
        {
            prev = m;
            m += (int)Math.floor(Math.sqrt(n));
            if(prev >= n)
            {
                return -1;
            }
        }
        
        // now do linear search
        while(arr[prev] < k)
        {
            prev++;
            if(prev == Math.min(m, n))
            {
                return -1;
            }
        }
        
        if(arr[prev] == k)
            return prev;
        
        return -1;
    }
}
