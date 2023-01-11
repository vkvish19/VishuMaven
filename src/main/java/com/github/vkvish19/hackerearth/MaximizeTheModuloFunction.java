package com.github.vkvish19.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// partially passing
public class MaximizeTheModuloFunction
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int t = Integer.parseInt(br.readLine());
            for(int j = 0; j < t; j++)
            {
                String[] inputs = br.readLine().split(" ");
                int m = Integer.parseInt(inputs[0]);
                int k = Integer.parseInt(inputs[1]);
                String numString = br.readLine();
                char[] num = numString.toCharArray();
    
                long modVal = 0;
                for(int i = 0; i < m; i++)
                {
                    int digit = num[i] - 48;
                    modVal = (modVal + (digit*power(10, m - i - 1, k)%k))%k;
                }
                
                int prev = 0;
                long answer = modVal;
                for(int i=0; i<m; i++)
                {
                    int digit = num[i] - 48;
                    modVal = (modVal - (digit*power(10, m-i-1, k))%k + k)%k;
                    answer = Math.max(answer, (prev+modVal)%k);
                    prev = (prev + (digit*power(10, m-i-2, k))%k)%k;
                }
                System.out.println(answer);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static int power(int a, int b, int k)
    {
        if(b == 0)
            return 1;
        
        int ans = 1;
        int val = a;
        while(b != 0)
        {
            if(b%2 != 0)
            {
                ans *= val;
                ans %= k;
            }
            val *= val;
            val %= k;
            b /= 2;
        }
        return ans;
    }
    
    protected static long getMaximumPossibleModValue(String num, int k)
    {
        if(Long.parseLong(num)%k == k - 1)
            return k - 1;
        
        long maxMod = 0;
        char[] numChar = num.toCharArray();
        for(int i = 0; i < num.length(); i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < num.length(); j++)
            {
                if(j != i)
                    sb.append(numChar[j]);
            }
            long currMod = Long.parseLong(sb.toString())%k;
            if(currMod > maxMod)
                maxMod = currMod;
        }
        return maxMod;
    }
}
