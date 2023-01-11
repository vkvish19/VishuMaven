package com.github.vkvish19.corejava.arrays;

public class ReplaceArrayElementsWithMultiplicationOfPreviousAndNext
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 4, 5, 6};
        multiplyPreviousAndNextElementsAndReplace(arr);
        ArraysUtil.printArrayElements(arr);
    }
    
    public static void multiplyPreviousAndNextElementsAndReplace(int[] arr)
    {
        if(arr.length == 1)
            return;
        int prev = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            int temp;
            if(i == arr.length - 1)
            {
                arr[i] = arr[i]*prev;
            }
            else
            {
                temp = arr[i];
                arr[i] = prev*arr[i + 1];
                prev = temp;
            }
        }
    }
}
