package com.github.vkvish19.leetcode;

public class RemoveDuplicatesFromSortedArray
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2};//{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {1, 2};//{0, 1, 2, 3, 4};
        int k = removeDuplicates(nums);
        
        assert k == expectedNums.length;
        System.out.println("k = " + k);
        for(int i = 0; i < k; i++)
        {
            System.out.print(nums[i] + " ");
            assert nums[i] == expectedNums[i];
        }
    }
    
    public static int removeDuplicates(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;
        
        int idx = 0;
        int count = 0;
        int p1 = 0;
        int p2 = 1;
        
        while(p2 < arr.length)
        {
            if(arr[p1] == arr[p2])
                count++;
            else
                arr[idx++] = arr[p1];
            
            p1++;
            p2++;
        }
        arr[idx] = arr[p1];
        
        return arr.length - count;
    }
}
