package DP.strings.wildcardMatching;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";

        boolean val = findMatching(s1, s2);

        System.out.println(val);
    }

    private static boolean findMatching(String p, String s)
    {
        int n = p.length();
        int m  = s.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, p, s, dp);
    }

    private static boolean solve(int i, int j, String s1, String s2, int[][] dp)
    {
        //base
        if(i < 0 && j < 0) return true;

        if(i < 0 && j >= 0) return false;

        if(j < 0 && i >= 0)
        {
            for(int k = 0 ; k <= i ; k++) if(s1.charAt(k) != '*') return false;
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
        {
            ans = solve(i - 1, j - 1, s1, s2, dp);
        }
        else if(s1.charAt(i) == '*')
        {
            ans = (solve(i - 1, j, s1, s2, dp) | solve(i, j - 1, s1, s2, dp));
        }
        else
        {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
