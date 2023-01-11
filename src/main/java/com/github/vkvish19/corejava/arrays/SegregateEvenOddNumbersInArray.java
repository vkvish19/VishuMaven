package com.github.vkvish19.corejava.arrays;

public class SegregateEvenOddNumbersInArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        segregateArrayElementsIntoEvenOdd(arr);
        ArraysUtil.printArrayElements(arr);
    }
    
    /**
     * we segregate the array elements into even and odd and then place the even valued elements at the beginning of the array and then the odd valued elements.
     * @param arr - array which we will be segregating into even and odd.
     */
    public static void segregateArrayElementsIntoEvenOdd(int[] arr)
    {
        int odd = -1;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                odd++;
                int temp = arr[odd];
                arr[odd] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
