package com.github.vkvish19.dynamic_programming.longestcommonsubsequence;

public class LongestCommonSubsequenceByTopDown
{
    public static void main(String[] args)
    {
        String x = "abcdgh";
        String y = "abedfhr";
        char[] xarr = x.toCharArray();
        char[] yarr = y.toCharArray();
        int m = xarr.length;
        int n = yarr.length;
        int longestCommonSubsequenceCountByTopDown = getLongestCommonSubsequenceCountByTopDown(xarr, yarr, m, n);
        System.out.println("longestCommonSubsequenceCountByTopDown = " + longestCommonSubsequenceCountByTopDown);
    }
    
    public static int getLongestCommonSubsequenceCountByTopDown(char[] xarr, char[] yarr, int m, int n)
    {
        int[][] t = new int[m+1][n+1];
        for(int i=0; i<m+1; i++)
        {
            for(int j=0; j<n+1; j++)
            {
                if(i==0 || j==0)
                    t[i][j] = 0;
            }
        }
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(xarr[i-1] == yarr[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else 
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[m][n];
    }
}
