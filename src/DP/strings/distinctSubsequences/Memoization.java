package DP.strings.distinctSubsequences;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        String s1 = "babgbag";
        String s2 = "bag";

        int ans = distinctSubSeq(s1, s2);
        System.out.println(ans);
    }

    private static int distinctSubSeq(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(len1 - 1, len2 - 1, s1, s2, dp);
    }

    private static int solve(int i, int j, String s1, String s2, int[][] dp)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = (solve(i - 1, j - 1, s1, s2, dp) + solve(i - 1, j, s1, s2, dp));
        }

        return dp[i][j] = solve(i - 1, j, s1, s2, dp);
    }
}
