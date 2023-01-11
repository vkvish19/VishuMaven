package com.github.vkvish19.corejava;

public class FindIfSumOf3IntegersInArrayIsEqualToGivenSum
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 7, 9, 10};
        int n = 8;
        isSumOfAny3IntegersInArrayEqualToGivenSum(arr, n);
    }
    
    protected static void isSumOfAny3IntegersInArrayEqualToGivenSum(int[] arr, int n)
    {
        int sum;
        boolean flag = false;
        for(int i = 0; i < arr.length - 2; i++)
        {
            sum = arr[i];
            for(int j = i + 1; j < arr.length - 1; j++)
            {
                sum += arr[j];
                for(int k = j + 1; k < arr.length; k++)
                {
                    if(sum + arr[k] == n)
                    {
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag)
                break;
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
