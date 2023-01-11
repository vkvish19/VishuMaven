package com.github.vkvish19.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JamesAndTheMenus
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] arr2d = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String[] nVals = br.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    arr2d[i][j] = Integer.parseInt(nVals[j]);
                }
            }
    
            int menuNumber = 1;
            int[] maxArr = new int[n];
            for(int j=0; j<m; j++)
            {
                int high = arr2d[0][j];
                int highFreq = 1;
                int iIndex = 0;
                for(int i=0; i<n; i++)
                {
                    if(arr2d[i][j] > high)
                    {
                        high = arr2d[i][j];
                        iIndex = i;
                        highFreq = 1;
                    }
                    else if(arr2d[i][j] == high)
                    {
                        highFreq++;
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
