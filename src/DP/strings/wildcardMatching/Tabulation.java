package DP.strings.wildcardMatching;

import java.util.Arrays;

public class Tabulation
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

        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;

        for(int j = 1 ; j <= m ; j++) dp[0][j] = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            boolean flag = true;
            for(int k = 1 ; k <= i ; k++)
            {
                if(p.charAt(k - 1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag ? 1 : 0;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                boolean ans;

                if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
                {
                    ans = dp[i - 1][j - 1] == 1;//solve(i - 1, j - 1, p, s, dp);
                }
                else if(p.charAt(i - 1) == '*')
                {
                    //ans = (solve(i - 1, j, p, s, dp) | solve(i, j - 1, p, s, dp));
                    ans = ( dp[i - 1][j] | dp[i][j - 1]) == 1;
                }
                else
                {
                    ans = false;
                }

                dp[i][j] = ans ? 1 : 0;
            }
        }
        return dp[n][m] == 1;
        //return solve(n - 1, m - 1, p, s, dp);
    }
}
