package DP.strings.LongestCommonSubString;

import java.util.Collections;

public class Optimal
{
    public static void main(String[] args)
    {
        String s1 = "abcd";
        String s2 = "abzd";

        int lcs = longestCommonSubsequence(s1, s2);

        System.out.println(lcs);
    }

    private static int longestCommonSubsequence(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];

        int len = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            int[] curr = new int[m + 1];
            for(int j = 1 ; j <= m ; j++)
            {
                //matching
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    curr[j] = 1 + prev[j - 1];
                    len =  Math.max(len, curr[j]);
                }
                else
                    curr[j] = 0; //Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
            prev = curr;
        }
        return len;
    }
}
