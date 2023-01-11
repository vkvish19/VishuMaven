package com.github.vkvish19.corejava.arrays;

public class RotateArrayUsingJugglingAlgorithm
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int d = 4;
        rotateArray(arr, d);
        ArraysUtil.printArrayElements(arr);
    }
    
    public static void rotateArray(int[] arr, int d)
    {
        // if d >= n
        d = d%arr.length;
        int temp;
        int gcd = getGCD(arr.length, d);
        for(int i = 0; i < gcd; i++)
        {
            temp = arr[i];
            int j = i;
            while(true)
            {
                int k = j + d;
                if(k >= arr.length)
                    k = k - arr.length;
                if(k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    
    public static int getGCD(int a, int b)
    {
        if(b == 0)
            return a;
        else
            return getGCD(b, a%b);
    }
}
