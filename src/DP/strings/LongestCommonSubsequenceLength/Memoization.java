package DP.strings.LongestCommonSubsequenceLength;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int lcs = longestCommonSubsequence(s1, s2);

        System.out.println(lcs);
    }

    private static int longestCommonSubsequence(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(len1 - 1, len2 - 1, s1, s2, dp);
    }

    private static int solve(int ind1, int ind2, String s1, String s2, int[][] dp)
    {
        //base case
        if(ind1 < 0 || ind2 < 0) return 0;


        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        //matching
        if(s1.charAt(ind1) == s2.charAt(ind2))
        {
            return dp[ind1][ind2] = 1 + solve(ind1 - 1, ind2 - 1, s1, s2, dp);
        }

        //not matches
        int path1 = solve(ind1 - 1, ind2, s1, s2, dp);
        int path2 = solve(ind1, ind2 - 1, s1, s2, dp);

        return dp[ind1][ind2] = Math.max(path1, path2);
    }
}
