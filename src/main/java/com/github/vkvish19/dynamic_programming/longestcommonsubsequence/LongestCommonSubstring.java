package com.github.vkvish19.dynamic_programming.longestcommonsubsequence;

public class LongestCommonSubstring
{
    public static void main(String[] args)
    {
        String x = "abcde";
        String y = "abfce";
        int m = x.length();
        int n = y.length();
        int longestCommonSubtringCount = getLongestCommonSubstringCount(x, y, m, n);
        System.out.println("longestCommonSubtringCount = " + longestCommonSubtringCount);
    }
    
    public static int getLongestCommonSubstringCount(String x, String y, int m, int n)
    {
        int[][] t = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++)
        {
            for(int j = 0; j < n + 1; j++)
            {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        
        for(int i = 1; i < m + 1; i++)
        {
            for(int j = 1; j < n + 1; j++)
            {
                if(x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = 0;
            }
        }
        int count = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                count = Math.max(count, t[i][j]);
            }
        }
        return count;
    }
}
