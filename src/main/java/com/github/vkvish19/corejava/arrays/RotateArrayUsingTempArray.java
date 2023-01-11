package com.github.vkvish19.corejava.arrays;

public class RotateArrayUsingTempArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rotateArray(arr, d);
        ArraysUtil.printArrayElements(arr);
    }
    
    /**
     * we take a temp array and store the first d elements in it.
     * then we move the remaining elements of main array towards the beginning of array.
     * then we place the temp array elements at the end of the new main array.
     * @param arr - array that is to be rotated
     * @param d - # of places the array elements to be moved.
     */
    public static void rotateArray(int[] arr, int d)
    {
        int[] temp = new int[d];
        for(int i=0; i<d; i++)
            temp[i] = arr[i];
        for(int i=0; i<arr.length-d; i++)
            arr[i] = arr[i+d];
        for(int i=0; i<temp.length; i++)
            arr[arr.length-d+i] = temp[i];
    }
}
