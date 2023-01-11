package com.github.vkvish19.dynamic_programming.longestcommonsubsequence;

/**
 * Here we are given 2 strings and we are asked to get the count of the longest common subsequence between them.
 * NOTE: subsequence means it need not be continuous. (Substring means it needs to be continuous)
 */
public class LongestCommonSubsequenceBaseProblem
{
    public static void main(String[] args)
    {
        String x = "abcdgh";
        String y = "abedfhr";
        char[] xarr = x.toCharArray();
        char[] yarr = y.toCharArray();
        int n = xarr.length;
        int m = yarr.length;
        int longestCommonSubsequenceCountByRecursion = getLongestCommonSubsequenceCountByRecursion(xarr, yarr, n, m);
        System.out.println("longestCommonSubsequenceCountByRecursion = " + longestCommonSubsequenceCountByRecursion);
    }
    
    public static int getLongestCommonSubsequenceCountByRecursion(char[] xarr, char[] yarr, int n, int m)
    {
        // base condition
        if(n==0 || m==0)
            return 0;
        //choice diagram
        if(xarr[n-1] == yarr[n-1])
        {
            return 1 + getLongestCommonSubsequenceCountByRecursion(xarr, yarr, n-1, m-1);
        }
        else
        {
            return Math.max(getLongestCommonSubsequenceCountByRecursion(xarr, yarr, n, m-1),
                    getLongestCommonSubsequenceCountByRecursion(xarr, yarr, n-1, m));
        }
    }
}
