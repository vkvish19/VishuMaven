package com.github.vkvish19.dynamic_programming.longestcommonsubsequence;

import java.util.Arrays;

// BOTTOM-UP APPROACH
public class LongestCommonSubsequenceByMemoization
{
    // t[n+1][m+1] - choose these n and m values depending on the string length constraints. Choose the max value.
    private static final int[][] T = new int[1001][1001];
    
    
    public static void main(String[] args)
    {
        String x = "abcdgh";
        String y = "abedfhr";
        char[] xarr = x.toCharArray();
        char[] yarr = y.toCharArray();
        int m = xarr.length;
        int n = yarr.length;
        initializeDP();
        int longestCommonSubsequenceCountByBottomUp = getLongestCommonSubsequenceCountByBottomUp(xarr, yarr, m, n);
        System.out.println("longestCommonSubsequenceCountByBottomUp (memoization) = " + longestCommonSubsequenceCountByBottomUp);
    }
    
    public static int getLongestCommonSubsequenceCountByBottomUp(char[] xarr, char[] yarr, int m, int n)
    {
        // base condition check
        if(m==0 || n==0)
            return 0;
        // check if already calculated for this combination & return stored value.
        if(T[m][n] != -1)
            return T[m][n];
        
        // choice diagram
        if(xarr[m-1] == yarr[n-1])
            return T[m][n] = 1 + getLongestCommonSubsequenceCountByBottomUp(xarr, yarr, m-1, n-1);
        else 
            return T[m][n] = Math.max(getLongestCommonSubsequenceCountByBottomUp(xarr, yarr, m-1, n),
                    getLongestCommonSubsequenceCountByBottomUp(xarr, yarr, m, n-1));
    }
    
    private static void initializeDP()
    {
        for(int[] ints : T)
        {
            Arrays.fill(ints, -1);
        }
    }
}
