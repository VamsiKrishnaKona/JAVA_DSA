package DP.strings.distinctSubsequences;

import java.util.Arrays;

public class Tabulation
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
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0 ; i < len1 + 1 ; i++)
        {
            dp[i][0] = 1;
        }

        for(int i = 1 ; i < len1 + 1 ; i++)
        {
            for(int j = 1 ; j < len2 + 1 ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] =  dp[i - 1][j - 1] + dp[i - 1][j]; //(solve(i - 1, j - 1, s1, s2, dp) + solve(i - 1, j, s1, s2, dp));
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];  //solve(i - 1, j, s1, s2, dp);
                }
            }
        }
        return dp[len1][len2];
    }
}
