package com.github.vkvish19.corejava.arrays;

public class RotateArrayUsingReverseAlgorithm
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 5;
        rotateArray(arr, d);
        ArraysUtil.printArrayElements(arr);
    }
    
    /**
     * 
     * @param arr - array that is to be rotated
     * @param d - # of places the array elements to be moved.
     */
    public static void rotateArray(int[] arr, int d)
    {
        d = d%arr.length;
        // reverse A
        reverseArray(arr, 0, d-1);
        // reverse B
        reverseArray(arr, d, arr.length-1);
        // reverse ArBr
        reverseArray(arr, 0, arr.length-1);
    }

    public static void reverseArray(int[] arr, int startIndex, int endIndex)
    {
        int temp;
        while(startIndex < endIndex)
        {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
