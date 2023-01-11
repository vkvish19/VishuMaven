package com.github.vkvish19.corejava.arrays;

public class RotateArrayUsingOneByOneApproach
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        
        rotateArray(arr, d);
        ArraysUtil.printArrayElements(arr);
    }
    
    /**
     * we copy 1st element of array to temp variable and then move all the remaining elements of the array.
     * we repeat this step for 'd' # of times.
     * @param arr - array that is to be rotated
     * @param d - # of places the array elements to be moved.
     */
    public static void rotateArray(int[] arr, int d)
    {
        for(int i=0; i<d; i++)
        {
            int temp = arr[0];
            for(int j=1; j<arr.length; j++)
            {
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = temp;
        }
    }
}
